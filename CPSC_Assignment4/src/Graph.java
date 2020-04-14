import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Class which models a graph using the adjacencyMatrix and functions to produce needed output
 * @author Garth Slaney
 *
 */
public class Graph {
	/**
	 * Number of rows in each neighborhood
	 */
	private int rows;
	/**
	 * Number of columns in each neighborhood
	 */
	private int cols;
	/**
	 * Number of vertices in total
	 */
	private int vertices;
	/**
	 * The adjacency matrix representation of the graph 
	 */
	private int[][] adjacencyMatrix;
	/**
	 * A three-dimensional matrix to store all the neighborhoods. The first is the vertex and the other two are row and column respectively
	 */
	private int[][][] neighbourhoods;
	/**
	 * Constructor for the Graph 
	 * @param row Number of rows 
	 * @param col Number of columns 
	 * @param vertex Number of vertices
	 */
	public Graph(int row, int col, int vertex) {
		rows = row;
		cols = col;
		vertices = vertex;
		adjacencyMatrix = new int[vertex][vertex];
		neighbourhoods = new int[vertex][row][col];
	}
	/**
	 * Copies the data from file into neighborhood array 
	 * @param vertex The vertex/id number to store data into 
	 * @param neighbourhood The neighborhood associated with the vertex 
	 */
	public void addNeighbour(int vertex, int[][] neighbourhood) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				neighbourhoods[vertex][i][j] = neighbourhood[i][j];
			}
		}
	}
	/**
	 * Test method to print the graphs for error checking 
	 */
	public void print() {
		 for(int i = 0; i < vertices; i++) {
			 System.out.println(i);
			 for(int j = 0; j < rows; j++) {
				 for(int k = 0; k < cols; k++) {
					 System.out.print(neighbourhoods[i][j][k] + " ");
				 }
				 System.out.println();
			 }
		 }
	}
	/**
	 * Builds the adjacency matrix using the findWeight function 
	 */
	public void buildMatrix() {
		for(int i = 0; i < vertices; i++) {
			for(int k = i + 1; k < vertices; k++) {
				int temp = findWeight(i, k);
				adjacencyMatrix[i][k] = temp;
				adjacencyMatrix[k][i] = temp;
			}
		}
	}
	/**
	 * Finds the appropriate weight of the connection between two vertexes 
	 * @param v1 The first vertex 
	 * @param v2 The second vertex
	 * @return The weight between the two vertexes 
	 */
	private int findWeight(int v1, int v2) {
		int dif = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j <cols; j++) {
				dif += Math.abs(neighbourhoods[v1][i][j] - neighbourhoods[v2][i][j]);
			}
		}
		return dif;
	}
	/**
	 * Prints the adjacency matrix to file
	 */
	public void printMatrix() {
		try {
			PrintWriter writer = new PrintWriter(rows + "x" + cols + "_GRAPH.txt", "UTF-8");
			writer.println("Edge"+  "\t" + "Weight");
			for(int i = 0; i < vertices; i++) {
				for(int k = i + 1; k < vertices; k++) {
					writer.println(i + " - " + k +"\t" + adjacencyMatrix[i][k]);
				}
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Performs a depth first travel search throughout the graph
	 */
	public void depthFirstTravel() {
		boolean visted[] = new boolean[vertices];
		for(int i = 0; i < vertices; i++) {
			visted[i] = false;
		}
		try {
			PrintWriter writer = new PrintWriter(rows + "x" + cols + "_DFT.txt", "UTF-8");
			writer.println("Edge"+  "\t" + "Weight");
			dptAdjMat(0, visted, writer);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	/**
	 * The recursive searching for the graph
	 * @param vertex The vertex currently at 
	 * @param visted The boolean matrix to track which vertices have been visited 
	 * @param writer The PrintWriter to write to the file 
	 */
	private void dptAdjMat(int vertex, boolean[] visted, PrintWriter writer) {
		visted[vertex] = true;
		for(int j = 0; j < vertices; j++) {
			if(!visted[j] && adjacencyMatrix[vertex][j] > 0) {
				writer.println(vertex + " - " + j +"\t" + adjacencyMatrix[vertex][j]);
				dptAdjMat(j, visted, writer);
			}
		}		
	}
	/**
	 * Print the minimum spanning tree to the file. 
	 */
	private void printMST(int parent[]) 
	{ 
		try {
			PrintWriter writer = new PrintWriter(rows + "x" + cols + "_MST.txt", "UTF-8");
			writer.println("Edge" + "\t" + "Weight"); 
			for (int i = 1; i < vertices ; i++) 
				writer.println(parent[i] + " - " + i + "\t" + adjacencyMatrix[i][parent[i]]); 
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	} 
	/**
	 * The code to generate a minimum spanning tree.
	 * Based from https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/ 
	 */
	public void primMST() 
	{ 
		int parent[] = new int[vertices]; 					  // Array to store constructed MST 
		int key[] = new int[vertices];    				 		// Key values used to pick minimum weight edge in cut 
		Boolean mstSet[] = new Boolean[vertices];  	  // To represent set of vertices not yet included in MST 

		for (int i = 0; i < vertices; i++) { 
			key[i] = Integer.MAX_VALUE;    //set value to infinity 
			mstSet[i] = false; 
		} 

		key[0] = 0; // Vertex 0 will be the first vertex 

		parent[0] = -1; // First node is always root of MST (-1 == null) 

		for (int count = 0; count < vertices - 1; count++) {  //basically while Q not parent 
			
			int min = minKey(key, mstSet); 

			mstSet[min] = true; 		//set value to true in boolean matrix so it doesn't pick it again

			for (int v = 0; v < vertices; v++) 
				if (adjacencyMatrix[min][v] != 0 && mstSet[v] == false && adjacencyMatrix[min][v] < key[v]) {   //sees if there are minimum values to add to the parent array
					parent[v] = min; 
					key[v] = adjacencyMatrix[min][v]; 
				} 
		} 
		
		printMST(parent); 
	} 		
	/**
	 * A utility function to find the vertex with minimum key 
	 * value, from the set of vertices not yet included in MST
	 * Based on https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
	 * @param key Key values used to pick minimum weight edge in cut 
	 * @param mstSet Array of booleans to track which vertices have been picked 
	 * @return The min value of the fringe
	 */
	private int minKey(int key[], Boolean mstSet[]) 
	{ 
		int min = Integer.MAX_VALUE; 
		int min_index = -1; 

		for (int v = 0; v < vertices; v++) 
			if (mstSet[v] == false && key[v] < min) { 
				min = key[v]; 
				min_index = v; 
			} 

		return min_index; 
	}
}

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * Main class of the program with implementation to read a file and calls necessary functions to output results
 * @author Garth Slaney
 *
 */
public class CPSC319W20A4 {
	
	public static void main(String args[]) {
		Graph theGraph = readFile(args[0]);
		theGraph.buildMatrix();
		theGraph.printMatrix();
		theGraph.depthFirstTravel();
		theGraph.primMST();
	}
	/**
	 * Reads the file using a Scanner and makes the Graph
	 * @return The Graph made from the input data 
	 */
	private static Graph readFile(String fileName) {
		try {
	    File f = new File(fileName); 
	    if(!f.exists()) {
	        System.out.println("File does not exist");
	        return null;
	    }
	    else if(!f.canRead()) {
	       System.out.println("File is not readable");
	       return null;
	   }
	    
	   Scanner bf = new Scanner(new FileReader(f));
	   int rows = bf.nextInt();
	   int cols = bf.nextInt();
	   int vertices = bf.nextInt();
		 Graph theGraph = new Graph(rows, cols, vertices);
		 
		 for(int i = 0; i < vertices; i++) {
			 int id = bf.nextInt();
			 int[][] neighbourhood = new int[rows][cols];
			 for(int j = 0; j < rows; j++) {
				 for(int k = 0; k < cols; k++) {
					 neighbourhood[j][k] = bf.nextInt();
				 }
			 }
			 theGraph.addNeighbour(id, neighbourhood);
		 }
		 
	   bf.close();
		return theGraph;
	} catch(IOException e) {
	   System.out.println("Unknow Exception");
	}
	return null; //somehow graph building failed 
	}
}
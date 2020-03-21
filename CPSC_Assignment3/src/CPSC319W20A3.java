import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CPSC319W20A3 {

	public static void main(String[] args) {
		String fileName = readInput();
		BinarySearchTree theTree = new BinarySearchTree( readFile(fileName) );
		theTree.displayOutput(fileName);
		boolean quit = false; // keeps track of quitting condition 
		Scanner scan = new Scanner(System.in);
		while(true) {
			printMenu();
			int key = scan.nextInt(); 
			scan.nextLine();		
			switch(key) {
				case 1:
					theTree.lookUp(scan, fileName);
					break;
				case 2:
					System.out.print("IN-ORDER output: ");
					theTree.inOrder(theTree.getRoot());
					System.out.println();
					break;
				case 3:
					System.out.print("PRE-ORDER output: ");
					theTree.preOrder(theTree.getRoot());
					System.out.println();
					break;
				case 4:
					System.out.print("POST-ORDER output: ");
					theTree.postOrder(theTree.getRoot());
					System.out.println();
					break;
				case 5:
					quit = true;
					break;
				default:
					System.out.println("Invalid input enetered. Please enter a different input.");
			}
			if(quit)
				break;
		}
	}
	/**
	 * Prints the menu for selecting what task the user wishes to do 
	 */
	private static void printMenu() {
		System.out.print("1.    Search for a word\n2.    Display the tree in-order\n3.    Display the tree in pre-order\n4.    Display the tree in post-order\n5.    Quit\n");
	}
	/**
	 * Reads the user input for a single line
	 * @return The string the user enters 
	 */
  private static String readInput() {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter the input filename: ");
		 String line = scan.next();
		 return line;
	}
	/**
	 * Reads the file using a BufferReader (most of the code taken from Tutorial: File I/O and Exceptions)
	 * @return The file in a String array 
	 */
  private static String[] readFile(String fileName) {
    StringBuilder line = new StringBuilder(); // I used String Builder as it has a better complexity than a regular String 
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
     BufferedReader bf = new BufferedReader(new FileReader(f));
     String s = bf.readLine();
     while(s != null) {
         line.append(s);
         if( !s.equals(""))    // require these two line as when testing would get words mashing together
        	 line.append(" ");   // the spaces are removed later meaning the words are not changed 
         s = bf.readLine();
     }
     bf.close();
  } catch(IOException e) {
     System.out.println("Unknow Exception");
  }
		return line.toString().replaceAll("[^0-9a-zA-Z ]", " ").toLowerCase().split("\\s+"); // converts to string and then using code splits the line
  }
  
}

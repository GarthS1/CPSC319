import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CPSC319W20A3 {

	public static void main(String[] args) {
		BinarySearchTree theTree = new BinarySearchTree( readFile() );
		theTree.display();
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
  private static String[] readFile() {
    StringBuilder line = new StringBuilder(); // I used String Builder as it has a better O(n) than a regular String 
	  try {
      File f = new File(readInput()); 
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
         s = bf.readLine();
     }
     bf.close();
  } catch(IOException e) {
     System.out.println("Unknow Exception");
  }
		return line.toString().replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+"); // converts to string and then using code spilts the line
  }
  
}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * @author kristin-k-opheim
 *
 */
public class DataMemory {
	private int max = 0x800;
	private int[] data = new int [max];
	private int i;
	
	public DataMemory(){
		
	}
	
	public void clear(){
		//clear the contents
		for(i = 0; i < max; i++) {
			data[i] = 0000;
		}
	}
	
	public void dump() {
		try {
		      PrintStream dump = new PrintStream(new File(
		          "DataDump.txt"));
		      PrintStream old = System.out;
		      System.setOut(dump);
		//Begin page 1 of output
		dump.println("Memory Dump--Data Memory     Page 1");
		
		for (i = 0; i < 1168; i++ ) {
			dumpSubCycle();
		}
		//Begin page 2 of output
		dump.println("Memory Dump--Data Memory     Page 2");
				
		for (i = 1168; i < 2048; i++ ) {
			dumpSubCycle();
		}
		
		//Notify the user there is nothing further
		dump.println("End Memory Dump--Data Memory\n");
	
	      dump.close();
	      
	      System.out.flush();
	      System.setOut(old);
	      
		    } catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    }
		finally {
			System.out.println("Data has been written to a file.");
		}
	}
	
		public void dumpSubCycle() {
			
			//establish row labels
			String newLine = Integer.toHexString(i).toUpperCase();
			//little cheater loop, to pad my row labels to be evenly spaced
			while (newLine.length()<3) {
				newLine = ("0" + newLine);
			}
			
			//temp tracks memory location, j is sub-counter for each cycle (row)
			int temp = data[i];
			int j;
			
			//output row labels and start printing data memory contents
			System.out.print(newLine);
			System.out.print(" ");
			
			//complete the row of contents
			for (j = 0; j < 16; j++) {
			temp = data[i];
			System.out.printf("%04X", temp);
			System.out.printf("  ");
			i++;
			}
			System.out.println("");
			i--;
		}
		
		public void load() {
			//take a file in to read
			String fileName = "Input.txt";
			String line = null;
			int x = 0;
			
			 try {
		         FileReader fileReader = new FileReader(fileName);
		         BufferedReader bufferedReader = new BufferedReader(fileReader);
		         
		         while((line = bufferedReader.readLine()) != null) {
		        	 char c = line.trim().charAt(0);
		        	 x = (int)c;
		        	 
		        	 switch (x) {
		             //store "d" and "D" lines as instruction memory
		              case 68:
		              case 100:
		            	  String addressLine = line.substring(2, 5);
		            	  int destination = Integer.parseInt(addressLine, 16);
		            	  
		            	  String numInstructions = line.substring(6, 8);
		            	  int j = Integer.parseInt(numInstructions, 16);
		            	  
		            	  // initial start and end indexes for instruction loads
		            	  int a = 8;
		            	  int b = a+4;
		            	  if (b > line.length()) {
		            		  b = (line.length()-1);
		            	  }
		            	 
		            	  
		            	  for (i = 0; i < j; i++){
	            	
	            		  //load instruction from that field, convert to int
		            		  String loadField = line.substring(a, b);
		            		 
	            		  int saveThis = Integer.parseInt(loadField, 16);
	            		  data[destination+i] = saveThis;
	            		  
	            		  //incrementing starting index
	            		  a = b;
	            		  //incrementing ending index
	            		  b += 4;
	            		  if (b > (12 + (4*j))) {
	            			  b = line.length()-1;
	            		  	}
	            	  }
		            	
		            	 ;
		              default: 
		            	  continue;

		         }
		         }
		         bufferedReader.close();         
		     }
		     catch(FileNotFoundException ex1) {
		         System.out.println("Unable to Open File");                
		     }
		     catch(IOException ex2) {
		         System.out.println("Error Reading File");                  
		     }
		}
		
	}


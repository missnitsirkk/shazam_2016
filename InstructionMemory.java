import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
 */

/**
 * @author kristin-k-opheim
 * the ROM class
 */
public class InstructionMemory {
	private int max = 0x400;
	private int[] instructions = new int [max];
	private int i;
	private int j;
	
	public InstructionMemory(){
	}
	
	public void clear(){
		//clear the contents
		for(i = 0; i < max; i++) {
			instructions[i] = 0x63000;
		}
	}
	public void dump() {
		//Begin page 1 of output
		System.out.println("Memory Dump--Instruction Memory   B = 000 T = 000 P = 000");
		
		for (i = 0; i < 224; i++ ) {
			dumpSubCycle();
		}
		//Begin page 2 of output
		System.out.println("Memory Dump--Instruction Memory     Page 2");
				
		for (i = 224; i < 1024; i++ ) {
			dumpSubCycle();
		}
		
		//Notify the user there is nothing further
		System.out.println("End Memory Dump--Instruction Memory");
	}
	
		public void dumpSubCycle() {
			
			//establish row labels
			String newLine = Integer.toHexString(i).toUpperCase();
			//little cheater loop, to pad my row labels to be evenly spaced
			while (newLine.length()<3) {
				newLine = ("0" + newLine);
			}
			
			//temp tracks memory location, j is sub-counter for each cycle (row)
			int temp = instructions[i];
			
			//output row labels and start printing data memory contents
			System.out.print(newLine);
			System.out.print(" ");
			//System.out.print(Integer.toHexString(temp).toUpperCase());
			//System.out.printf("%05d", Integer.toHexString(temp).toUpperCase());
			//System.out.print(" ");
			
			//complete the row of contents
			for (j = 0; j < 16; j++) {
			temp = instructions[i];
			String formatted = Integer.toHexString(temp).toUpperCase();
			while (formatted.length()<5) {
				formatted = ("0" + formatted);
			}
			System.out.print(formatted);
			//System.out.printf("%05x", Integer.toHexString(temp).toUpperCase());
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
		             //store "i" and "I" lines as instruction memory
		              case 73:
		              case 105:
		            	  String addressLine = line.substring(2, 5);
		            	  int destination = Integer.parseInt(addressLine, 16);
		            	  
		            	  String numInstructions = line.substring(6, 7);
		            	  j = Integer.parseInt(numInstructions, 16);
		            	  
		            	  // initial start and end indexes for instruction loads
		            	  int a = 8;
		            	  int b = 13;
		            	  
		            	  for (i = 0; i < j; i++){
		            	
		            		  //load instruction from that field, convert to int
		            		  String loadField = line.substring(a, b);
		            		  int doThis = Integer.parseInt(loadField, 16);
		            		  instructions[destination+i] = doThis;
		            		  
		            		  //incrementing starting index
		            		  a = b;
		            		  //incrementing ending index
		            		  b += 5;
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

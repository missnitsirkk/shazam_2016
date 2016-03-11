# shazam_2016
computer org project

import java.io.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// establish array for memory locations
		String memLoc[] = new String [2048];
		int i = 0;
		int j = 0; 
		
		//start clear dump, page 1
		System.out.println("Memory Dump--Data Memory     Page 1");
		
		for (i = 0; i < 1168; i++ ) {
			
			String temp = Integer.toHexString(i).toUpperCase();
			
			while (temp.length()<3) {
				temp = ("0" + temp);
			}
			
			System.out.print(temp);
			
			for (j=0; j < 16; j++) {
				memLoc[i+j] = "0000";
				
				if (j<15){
				System.out.print("  " + memLoc[i+j]);
				}
				
			}
			
			i = i+15;
			System.out.println("  " + memLoc[i]);
		}
		
		//clear dump, page 2
		System.out.println("Memory Dump--Data Memory     Page 2");
		
		for (i = 1168; i < 2048; i++ ) {
			
			String temp = Integer.toHexString(i).toUpperCase();
			
			//while (temp.length()<3) {
			//	temp = ("0" + temp);
			//}
			
			System.out.print(temp);
			
			for (j=0; j < 16; j++) {
				memLoc[i+j] = "0000";
				
				if (j<15){
				System.out.print("  " + memLoc[i+j]);
				}
				
			}
			
			i = i+15;
			System.out.println("  " + memLoc[i]);
		}
		
		System.out.println("End Memory Dump--Data Memory\n");
		
		System.out.println("Memory Dump--Instruction Memory   B = 000 T = 000 P = 000");
		System.out.println("Memory Dump--Instruction Memory     Page 1");
		
		String instructMem[] = new String [1024];
		
		for (i = 0; i < 224; i++ ) {
			
			String temp = Integer.toHexString(i).toUpperCase();
			
			while (temp.length()<3) {
				temp = ("0" + temp);
			}
			
			System.out.print(temp);
			
			for (j=0; j < 16; j++) {
				instructMem[i+j] = "63000";
				
				if (j<15){
				System.out.print("  " + instructMem[i+j]);
				}
				
			}
			
			i = i+15;
			System.out.println("  " + instructMem[i]);
		}
		
		System.out.println("Memory Dump--Instruction Memory     Page 2");
		
		
		for (i = 224; i < 1024; i++ ) {
			
			String temp = Integer.toHexString(i).toUpperCase();
			
			while (temp.length()<3) {
				temp = ("0" + temp);
			}
			
			System.out.print(temp);
			
			for (j=0; j < 16; j++) {
				instructMem[i+j] = "63000";
				
				if (j<15){
				System.out.print("  " + instructMem[i+j]);
				}
				
			}
			
			i = i+15;
			System.out.println("  " + instructMem[i]);
		}
		
		System.out.println("End Memory Dump--Instruction Memory");

	
	//take a file in to read
	
	String fileName = "Input.txt";
	String line = null;
	int c = 0;
	
	 try {
         FileReader fileReader = new FileReader(fileName);
         BufferedReader bufferedReader = new BufferedReader(fileReader);

         while((line = bufferedReader.readLine()) != null) {
             System.out.println(line);
             
             char input[] = new char [line.toCharArray().length];
             input = line.toCharArray();
            
             c = (int)input[0];
             
             if (c == 73 | c == 105) {
            	 int max = line.length();
            	 System.out.println("Testing max..." + max);
            	 String address = (""+input[2]+ input[3] + input[4]);
                 System.out.println("Testing address..." + address);
            	 int startLoc = Integer.parseInt(address, 16);
            	 c = Character.getNumericValue(input[6]);
            	 if (c > 0) {
            		 c = 8;
            		 while (c + 4 < max){
            		 instructMem[startLoc] = (""+ input[c]+input[c+1]+input[c+2]+input[c+3]);
            		 System.out.println("Added: " + instructMem[startLoc]);
            		 c = c + 4;
            		 startLoc++;
            		 }
            	}
            else {
            		 
            	 }
             }
         }   
         bufferedReader.close();         
     }
     catch(FileNotFoundException ex1) {
         System.out.println("Unable to Open File");                
     }
     catch(IOException ex2) {
         System.out.println("Error Reading File ");                  
     }
     
     
	}
}

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
		//Begin page 1 of output
		System.out.println("Memory Dump--Data Memory     Page 1");
		
		for (i = 0; i < 1168; i++ ) {
			dumpSubCycle();
		}
		//Begin page 2 of output
		System.out.println("Memory Dump--Data Memory     Page 2");
				
		for (i = 1168; i < 2048; i++ ) {
			dumpSubCycle();
		}
		
		//Notify the user there is nothing further
		System.out.println("End Memory Dump--Data Memory\n");
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
			//System.out.printf("%04d", temp);
			//System.out.print(" ");
			
			//complete the row of contents
			for (j = 0; j < 16; j++) {
			temp = data[i];
			System.out.printf("%04d", temp);
			System.out.printf("  ");
			i++;
			}
			System.out.println("");
			i--;
		}
	}


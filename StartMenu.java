import java.io.*;
import java.util.Scanner;

/**
 * @author kristin-k-opheim
 *
 */
public class StartMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Set-up
		DataMemory shazamData = new DataMemory();
		shazamData.clear();
		InstructionMemory shazamInstructions = new InstructionMemory();
		shazamInstructions.clear();
		CPU shazam = new CPU();
		String loc = "000";
		String B = String.format("%03X", shazam.getbRegister());
		String T = String.format("%03X", shazam.gettRegister());
		int[] instruction = shazamInstructions.getInstructions();
		
		
		boolean trace = true;
		
		try {
			PrintWriter traceOutput = new PrintWriter("TraceOutput.txt", "UTF-8");
			traceOutput.println("Interpreter --- Begin location " + loc + " B = " + B + " T = "+ T);
			traceOutput.println("Trace is... On");
			traceOutput.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Log Trace Failed.");
			ex.printStackTrace();
		} catch (UnsupportedEncodingException ex) {
			System.out.println("Log Trace Failed.");
			ex.printStackTrace();
		}
		
		//Welcome, Choose Option
		System.out.println("SHAZAM 2016\n\nChoose an Option by Number:");
		System.out.println("\n1 Clear \n2 Dump\n3 Load\n4 Interpret\n0 Quit");
		Scanner scnr = new Scanner(System.in);
		int input = scnr.nextInt();
	
		while (input != 0){
		switch(input){
		case 1: 
			shazamData.clear();
			shazamInstructions.clear();
			System.out.println("Data and Instructions have been cleared.\n");
			input = scnr.nextInt();
			break;
		case 2: 
			shazamData.dump();
			shazamInstructions.dump();
			System.out.println("Please check project folder.\n");
			input = scnr.nextInt();
			break;
		case 3: 
			shazamData.load();
			shazamInstructions.load();
			System.out.println("Your Input File has been loaded.\n");
			input = scnr.nextInt();
			break;
		case 4: 
			for (int i = 0; i < 0x400; i++) {
				shazam.setiRegister(shazamInstructions.getInstruction(i));
			}
			break;
		default: 
			System.out.println("Invalid Command.\n");
			input = scnr.nextInt();
			break;
		}
		}
		System.out.println("Done.");
	}

}

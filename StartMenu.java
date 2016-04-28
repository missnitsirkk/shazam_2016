import java.io.*;

/**
 * @author kristin-k-opheim
 *
 */
public class StartMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Welcome, Choose Option
		System.out.println("SHAZAM 2016\n\nChoose an Option by Number:");
		System.out.println("\n1 Clear \n2 Dump\n3 Load\n");
		
		DataMemory shazamData = new DataMemory();
		shazamData.clear();
		shazamData.dump();
		
		InstructionMemory shazamInstructions = new InstructionMemory();
		shazamInstructions.clear();
		
		shazamInstructions.load();
		shazamInstructions.dump();

	}

}

/**
 * 
 */

/**
 * @author kristin-k-opheim
 *
 */
public class CPU {
	
	private int pRegister;
	private int bRegister;
	private int tRegister;
	private int iRegister;
	
	private int Register1;
	private int Register2;
	private int Register3;
	private int Register4;
	private int Register5;
	
	public CPU() {
		pRegister = 000;
		bRegister = 000;
		tRegister = 002;
		iRegister = 000;
		
		Register1 = 0;
		Register2 = 0;
		Register3 = 0;
		Register4 = 0;
		Register5 = 0;
	}

	public int getpRegister() {
		return pRegister;
	}

	public void setpRegister(int pRegister) {
		this.pRegister = pRegister;
	}

	public int getbRegister() {
		return bRegister;
	}

	public void setbRegister(int bRegister) {
		this.bRegister = bRegister;
	}

	public int gettRegister() {
		return tRegister;
	}

	public void settRegister(int tRegister) {
		this.tRegister = tRegister;
	}

	public int getiRegister() {
		return iRegister;
	}

	public void setiRegister(int iRegister) {
		this.iRegister = iRegister;
	}

	public int getRegister1() {
		return Register1;
	}

	public void setRegister1(int register1) {
		Register1 = register1;
	}

	public int getRegister2() {
		return Register2;
	}

	public void setRegister2(int register2) {
		Register2 = register2;
	}

	public int getRegister3() {
		return Register3;
	}

	public void setRegister3(int register3) {
		Register3 = register3;
	}

	public int getRegister4() {
		return Register4;
	}

	public void setRegister4(int register4) {
		Register4 = register4;
	}

	public int getRegister5() {
		return Register5;
	}

	public void setRegister5(int register5) {
		Register5 = register5;
	}


}

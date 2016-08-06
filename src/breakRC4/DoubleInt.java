package breakRC4;

public class DoubleInt {
	private int key;
	private int type;
	
	public DoubleInt (int num1, int num2){
		key = num1;
		type = num2;
	}
	
	public int getKey(){
		return key;
	}
	
	public int getType(){
		return type;
	}
}

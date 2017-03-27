package leetcode;

public class LC504 {

	public static void main(String[] args) {
		System.out.println(convertToBase7(-8));

	}

	public static String convertToBase7(int num) {
        StringBuilder builder = new StringBuilder("");
        
        return appendNumber(builder, num);
    }

	private static String appendNumber(StringBuilder builder, int i) {
		if(i == 0){
			if(builder.toString().equals("")){
				return "0";
			}
			return builder.toString();
		}
		
		appendNumber(builder, i/7);
		if(builder.toString().startsWith("-")){
			return builder.append(Math.abs(i)%7).toString();	
		}
		return builder.append(i%7).toString();
	}
}

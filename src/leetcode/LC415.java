package leetcode;

public class LC415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("3487", "19"));
	}

    public static String addStrings(String num1, String num2) {
        int leng, leng1, leng2;
        
        leng1 = num1.length();
        leng2 = num2.length();
        
        if(leng1 >= leng2){
        	leng = leng1;
        	for(int i = 0; i<leng - leng2; i++){
        		num2 = "0" + num2;
        	}
        } else{
        	leng = leng2;
        	for(int i = 0; i<leng - leng1; i++){
        		num1 = "0" + num1;
        	}
        }

        boolean addMore = false;
        String ans = "";
        while(leng >0){
        	int temp = Character.getNumericValue(num1.charAt(leng-1)) + Character.getNumericValue(num2.charAt(leng-1));
        	if(addMore){
        		ans = (temp+1)%10 + ans;
        		if(temp +1 < 10){
            		addMore = false;
            	}
        	} else{
        		ans = temp%10 + ans;
        		if(temp >= 10){
        			addMore = true;
        		}
        	}
        	
        	leng--;
        }
        
        if(addMore){
        	ans = "1" + ans;
        }
        
        return ans;
    }
}

package leetcode;

public class LC520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(detectCapitalUse("leetcode"));
	}

public static boolean detectCapitalUse(String word) {
        boolean firstLetterCapital = false;
        boolean secondLetterCapital = false;
        
        char[] arr = word.toCharArray();
        for(int i =0; i<arr.length; i++){
        	if(i == 0 && Character.isUpperCase(arr[i])){
        		firstLetterCapital = true;
        	} else if(i == 1 && Character.isUpperCase(arr[i])){
        		if(!firstLetterCapital){
        			return false;
        		}
        		secondLetterCapital = true;
        	} else {
        		if((firstLetterCapital && secondLetterCapital && Character.isLowerCase(arr[i])) || (firstLetterCapital && !secondLetterCapital && Character.isUpperCase(arr[i])) || (!firstLetterCapital && Character.isUpperCase(arr[i]))){
        			return false;
        		}
        	}
        }
        
        return true;
    }
}

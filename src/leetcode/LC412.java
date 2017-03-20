package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(15);
	}

	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		
        for (int i = 1; i<= n; i++ ){
        	if(i%15 == 0){
        		list.add("FizzBuzz");
        	} else if(i%3==0){
        		list.add("Fizz");
        	} else if(i%5==0){
        		list.add("Buzz");
        	} else{
        		list.add(String.valueOf(i));
        	}
        	//System.out.println(list.get(i-1));
        }
        
        return list;
    }
}

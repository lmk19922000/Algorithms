package Misc;

import java.io.*;
import java.util.HashMap;

public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String input[] = line.split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        line = br.readLine();
        input = line.split(" ");
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        
        int total = 0;
        int temp;
        for (int i = 0; i<N; i++){
        	temp = Integer.parseInt(input[i]);
        	table.put(temp, temp);
        	if (table.containsKey(temp-K)){
        		total++;
        	}
        	if (table.containsKey(temp+K)){
        		total++;
        	}
        }
        
        System.out.println(total);
	}

}

package Misc;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

public class Solution {
	
	static int[][] farmland;
	static int S;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		S = Integer.parseInt(line);

		String rawInput[];
		farmland = new int[S][S];

		for (int i = 0; i < S; i++) {
			line = br.readLine();
			rawInput = line.split(" ");
			for (int j = 0; j < S; j++) {
				farmland[i][j] = Integer.parseInt(rawInput[j]);
			}
		}
		
		int[][] labeled = new int[S][S];
		int count = 0; // count the number of label
		LinkedList<Pair> queue = new LinkedList<Pair>();
		
		// Initialization
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < S; j++) {
				labeled[i][j] = 0;
			}
		}

		Vector<Pair> positions;
		boolean flag = true;
		// Find all the sinks
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < S; j++) {
				positions = getNeighbors(i, j);

				flag = true;
				for (int k = 0; k < positions.size(); k++) {
					if (farmland[i][j] >= farmland[positions.get(k).first][positions
							.get(k).second]) {
						flag = false;
						break;
					}
				}

				if (flag) {
					count++;
					labeled[i][j] = count;
					queue.add(new Pair(i, j));
				}
			}
		}
		
		Pair current;
		Vector<Pair> pos;
		while (!queue.isEmpty()) {
			current = queue.poll();
			int i = current.first;
			int j = current.second;

			positions = getNeighbors(i, j);
			for (int k = 0; k < positions.size(); k++) {
				if (labeled[positions.get(k).first][positions.get(k).second] != 0) {
					continue;
				}

				pos = getNeighbors(positions.get(k).first,
						positions.get(k).second);

				// find the lowest neighbor
				Pair min;
				min = pos.get(0);
				for (int l = 1; l < pos.size(); l++) {
					current = pos.get(l);
					if (farmland[current.first][current.second] < farmland[min.first][min.second]) {
						min = current;
					}
				}

				if (labeled[min.first][min.second] != 0) {
					labeled[positions.get(k).first][positions.get(k).second] = labeled[min.first][min.second];
					queue.add(positions.get(k));
				}
			}
		}

		// Count the number of label
		Vector<Integer> result = new Vector<Integer>();
		for (int i = 0; i < count; i++) {
			result.add(0);
		}
		
		int oldValue;
		for (int i = 0; i < S; i++) {
			for (int j = 0; j < S; j++) {
				oldValue = result.get(labeled[i][j] - 1);
				oldValue++;
				result.set(labeled[i][j] - 1, oldValue);
			}
		}
		
		Collections.sort(result);
		
		for (int i = 0; i < result.size() - 1; i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.print(result.get(result.size() - 1));
        
		/**
		 * Palantir sample test
		 */
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];
        
        for (int i = 0; i<frequency1.length; i++){
        	frequency1[i] = 0;
        }
        
        for (int i = 0; i<frequency2.length; i++){
        	frequency2[i] = 0;
        }
        
        if (str1.length() != str2.length()){
        	System.out.println("Not anagrams!");
        	return;
        }
        
        for (int i = 0; i <str1.length(); i++){
        	frequency1[str1.charAt(i)-0]++;
        }
        
        for (int i = 0; i <str2.length(); i++){
        	frequency2[str2.charAt(i)-0]++;
        }
        
        for (int i = 0; i<str1.length(); i++){
        	if (frequency1[i] != frequency2[i]){
        		System.out.println("Not Anagrams!");
        		return;
        	}
        }
        
        System.out.println("Anagrams!");
        */
		
        /**
         * Facebook Hackathon challenge
         */
        /*       
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
        */
	}
	
	public static Vector<Pair> getNeighbors(int i, int j){
		Vector<Pair> ans = new Vector<Pair>();
		
		int[] moveRow = new int[]{-1, 0, 1};
		int[] moveCol = new int[]{-1, 0, 1};
		
		for (int k = 0; k<moveRow.length; k++){
			for (int l = 0; l<moveCol.length; l++){
				if (moveRow[k]==moveCol[l] && moveRow[k]==0){
					continue;
				}
				if (i+moveRow[k]<S && i+moveRow[k]>-1 && j+moveCol[l]<S && j+moveCol[l]>-1){
					ans.add(new Pair(i+moveRow[k], j+moveCol[l]));
				}
			}
		}
		
		return ans;
	}
}

class Pair{
	public int first;
	public int second;
	
	public Pair(int _first, int _second){
		first = _first;
		second = _second;
	}
}
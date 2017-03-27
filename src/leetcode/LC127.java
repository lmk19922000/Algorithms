package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC127 {


	
	public static void main(String[] args) {
		String beginWord = "qa";
		String endWord = "sq";
		List<String> wordList = Arrays.asList("ab","ac","nc","qa","qb","sc","uh","wm","an","me","mo","na","la","st","er","sc", "sq","ye");
		
		System.out.print(ladderLength(beginWord, endWord, wordList));

	}

public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
	Map<String, Integer> map = new HashMap<String, Integer>();
	Queue<String> queue = new PriorityQueue<String>();
	
	queue.add(beginWord);
	map.put(beginWord, 1);
	
	while(!queue.isEmpty()){
		String targetWord = queue.poll();
		
		for(String word: wordList){
        	// Check if word has been visited before
        	if(map.get(word) == null){
            	int count = 0;
            	for(int i = 0; i<targetWord.length();i++){
            		if(targetWord.charAt(i) != word.charAt(i)){
            			count++;
            		}
            		if(count > 1){
            			break;
            		}
            	}

            	if(count == 1){
            		if(word.equals(endWord)){
                		return 1 + map.get(targetWord);
                	}
            		queue.add(word);
            		map.put(word, 1 + map.get(targetWord));
            	}
        	}
        }
	}
        
    return 0; 
    }
}

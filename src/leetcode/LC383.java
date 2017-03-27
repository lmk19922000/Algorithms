package leetcode;

public class LC383 {
	public static void main(String[] args) {

	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] counts = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			counts[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			counts[ransomNote.charAt(i) - 'a']--;
			if (counts[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		return true;
	}
}

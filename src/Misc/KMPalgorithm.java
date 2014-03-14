package Misc;

public class KMPalgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "le minh khue, lekhue, khu.le khuele minh akioh";
		String str2 = "khuele";
		
		System.out.println(isSubstring(str1, str2));
	}
	
	public static boolean isSubstring(String searchStr, String pattern){
		int[] table = new int[pattern.length()];
		
		int pos, cnd;
		
		if (pattern.length()>0){
			table[0] = -1;
		}
		if (pattern.length()>1){
			table[1] = 0;
		}
		
		pos = 2;
		cnd = 0;
		
		while (pos<pattern.length()){
			if (pattern.charAt(pos) == pattern.charAt(cnd)){
				cnd++;
				table[pos] = cnd;
				pos++;
			} else if (cnd > 0){
				cnd = table[cnd];
			} else{
				table[pos] = 0;
				pos++;
			}
		}
		
		int m, i;
		m=0; i=0;
		
		while (m+i<searchStr.length()){
			if (searchStr.charAt(m+i) == pattern.charAt(i)){
				if (i == pattern.length()-1){
					return true;
				}
				i++;
			} else{
				m = m+i-table[i];
				if (table[i] > -1){
					i = table[i];
				} else{
					i = 0;
				}
			}
		}
		
		return false;
	}
}

package leetcode;

public class LC292 {
    public boolean canWinNim(int n) {
        int[] arr = new int[1000000];
        
        for (int i = 0; i<1000000; i++){
            arr[i] = -1;
        }
        arr[1] = arr[2] = arr[3] = 1;
        
        return canWinRec(n, arr);
    }
    
    public boolean canWinRec(int n, int[] arr){
        if(arr[n] != -1)
            return arr[n] == 1;
        
        if(!canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3)){
            arr[n] = 1;
            return true;
        } else{
            arr[n] = 0;
            return false;
        }
    }
}

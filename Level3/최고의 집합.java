import java.util.*;
class 최고의_집합 {
    public int[] solution(int n, int s) {
        if(s/n==0) return new int[]{-1};
        int[] ret = new int[n];
        Arrays.fill(ret, s/n);
        int sum = s/n*n, idx=n-1;
        while(sum<s) {
        	ret[idx--]++;
        	sum++;
        }
        return ret;
    }
}
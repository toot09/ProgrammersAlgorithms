import java.util.*;
class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length<=1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int n : arr) {
            min = Math.min(min, n);
        }
        int[] ret = new int[arr.length-1];
        int idx = 0;
        for(int n : arr) {
            if(n==min) continue;
            ret[idx++] = n;
        }
        return ret;
    }
}
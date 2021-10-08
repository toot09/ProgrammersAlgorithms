import java.util.*;
class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        if(divisor==1) {
            Arrays.sort(arr);
            return arr;
        }
        List<Integer> list = new ArrayList<>();
        for(int n : arr) {
            if(n%divisor==0) list.add(n);
        }
        if(list.size()==0) return new int[]{-1};
        int[] ret = new int[list.size()];
        for(int i=0 ; i<ret.length ; i++) {
            ret[i] = list.get(i);
        }
        Arrays.sort(ret);
        return ret;
    }
}
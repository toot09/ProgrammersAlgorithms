import java.util.*;
class REDO_줄_서는_방법 {
    public int[] solution(int n, long k) {
        int[] ret = new int[n];
        List<Integer> nums = new ArrayList<>();
        long num = 1;
        int idx = 0;
        
        for(int i=1 ; i<=n ; i++) {
            nums.add(i);
            num *= i;
        }
        
        k--;
        //num = 2
        while(idx<ret.length) {
            num /= (n--);
            int i = (int)(k/num); // idx = 2
            ret[idx++] = nums.get(i);
            nums.remove(i);
            k %= num;
        }
        return ret;
    }
}
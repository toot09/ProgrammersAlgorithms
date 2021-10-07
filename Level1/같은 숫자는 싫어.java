import java.util.*;
class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<arr.length ; i++) {
            while(i+1<arr.length && arr[i]==arr[i+1]) i++;
            list.add(arr[i]);
        }
        int[] ret = new int[list.size()];
        for(int i=0 ; i<ret.length ; i++) ret[i] = list.get(i);
        return ret;
    }
}
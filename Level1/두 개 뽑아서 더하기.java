import java.util.*;
class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i<numbers.length-1 ; i++) {
            for(int j=i+1; j<numbers.length ; j++) {
                if(!list.contains(numbers[i]+numbers[j])) list.add(numbers[i]+numbers[j]);
            }
        }
        int[] ret = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) ret[i] = list.get(i);
        Arrays.sort(ret);
        return ret;
    }
}
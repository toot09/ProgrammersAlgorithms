import java.util.*;
class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int max = nums.length/2;
        for(int num : nums) hs.add(num);
        return hs.size()>=max?max:hs.size();
    }
}
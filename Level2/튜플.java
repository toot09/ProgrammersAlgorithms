import java.util.*;
class tuple {
    public int[] tuple(String s) {
        String[] nums = s.replaceAll("[}]"," ").replaceAll("[{]"," ").trim().split(" , ");
        Arrays.sort(nums, (a,b)->{
            return a.length()-b.length();
        });
        Set<Integer> hs = new HashSet<>();
        int[] ret = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++) {
            String[] num = nums[i].split(",");
            for(String str : num) {
                int n = Integer.valueOf(str);
                if(!hs.contains(n)) {
                    hs.add(n);
                    ret[i] = n;
                    break;
                }
            }
        }
        return ret;
    }
}

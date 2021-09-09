import java.util.*;
class sscg {
    private int ret = 0;
    private boolean[] primes;
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1 ; i>=0 ; i--) {
            sb.append(nums[i]);
        }
        int max = Integer.valueOf(sb.toString());
        primes = new boolean[max+1];
        for(int i=2 ; i<=max/2 ; i++) {
            for(int j=2 ; j*i<=max ; j++) {
                primes[i*j] = true;
            }
        }
        helper(nums, visit, "");
        return ret;
    }
    public void helper(char[] nums, boolean[] visit, String n) {
        if(n.length()>0) {
            int num = Integer.valueOf(n);
            if(num!=0 && num!=1 && !primes[num]) ret++;
        }
        for(int i=0 ; i<nums.length ; i++) {
            if(visit[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !visit[i-1]) continue;
            if(n.length()==0 && nums[i]=='0') continue;
            visit[i] = true;
            helper(nums, visit, n+nums[i]);
            visit[i] = false;
        }
    }
}
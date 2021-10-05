import java.util.*;
class ssmdg {
    public int solution(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int max = nums[len-1]+nums[len-2]+nums[len-3];
        boolean[] primes = new boolean[max+1];
        for(int i=2 ; i<=max/2 ; i++) {
            for(int j=2 ; (j*i)<=max ; j++) primes[i*j] = true;
        }
        return getCount(0, 0, 0, nums, primes);
    }
    public int getCount(int idx, int cnt, int sum, int[] nums, boolean[] primes) {
        if(cnt==3) {
            return !primes[sum]?1:0;
        }
        int ret = 0;
        for(int i=idx ; i<nums.length ; i++) {
            ret += getCount(i+1, cnt+1, sum+nums[i], nums, primes);
        }
        return ret;
    }
}
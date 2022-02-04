import java.util.*;
class N으로_표현 {
    public int solution(int N, int number) {
        Set<Integer>[] nums = new HashSet[9];
        int num = 0, ret=9;
        for(int i=1 ; i<=8 ; i++) {
        	num = num*10+N;
        	nums[i] = new HashSet<>();
        	nums[i].add(num);
        	if(num==number) return i;
        }
        for(int i=1 ; i<=8 ; i++) {
        	Set<Integer> hs1 = nums[i];
        	for(int j=1 ; j<=i && i+j<=8 ; j++) {
        		Set<Integer> hs2 = nums[j];
        		for(int n1 : hs1) {
        			for(int n2 : hs2) {
        				if(n1+n2!=0) nums[i+j].add(n1+n2);
                        if(n1*n2!=0) nums[i+j].add(n1*n2);
        				if(n1/n2!=0) nums[i+j].add(n1/n2);
        				if(n2/n1!=0) nums[i+j].add(n2/n1);
        				if(n1-n2!=0) nums[i+j].add(n1-n2);
        				if(n2-n1!=0) nums[i+j].add(n2-n1);
        			}
        		}
        		//if(nums[i+j].contains(number)) ret = Math.min(ret, i+j);
                if(nums[i+j].contains(number)) return i+j;
        	}
        }
        //return ret>8?-1:ret;
        return -1;
    }
}
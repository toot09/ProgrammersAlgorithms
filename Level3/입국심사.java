import java.util.*;
class 입국심사 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = times[times.length-1]*(long)n, min=1;
        while(min<=max) {
        	long mid = min + (max-min)/2;
        	long sum = 0;
        	for(int i=0 ; i<times.length ; i++) {
        		sum += (long)(mid/(long)times[i]);
        	}
        	if(sum<(long)n) {
        		min = mid+1;
        	} else {
        		max = mid-1;
        	}
        }
        return min;
    }
}
import java.util.*;
class 야근_지수 {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
		while(n>0) {
			int idx=works.length-1, max = works[idx];
			while(idx>=0 && works[idx]==max && n>0) {
				works[idx--]--;
				n--;
			}
		}
		if(works[works.length-1]<0) return 0;
		long ret = 0;
		for(int w : works) ret += Math.pow(w, 2);
		
		return ret;
    }
}
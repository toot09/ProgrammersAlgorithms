import java.util.*;
class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b)->{
			return a[1]-b[1];
		});
		int s=0, e=0, ret=0;
		while(s<routes.length) {
			while(s<routes.length && routes[s][0]<=routes[e][1]) {
				s++;
			}
			e=s;
			ret++;
		}
		return ret;
    }
}
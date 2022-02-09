class REDO_기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int idx=0, s=1, cnt=0;
        while(s<=n) {
        	if(idx>=stations.length || s<stations[idx]-w) {
        		cnt++;
        		s += (2*w+1);
        	} else {
        		s = stations[idx++]+w+1;
        	}
        }
        return cnt;
    }
}
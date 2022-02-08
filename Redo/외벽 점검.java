class REDO_외벽_점검 {
    private int ret;
    public int solution(int n, int[] weak, int[] dist) {
        ret = Integer.MAX_VALUE;
        int m = weak.length;
        int[] weaks = new int[2*m];
        for(int i=0 ; i<m ; i++) {
        	weaks[i] = weak[i];
        	weaks[i+m] = weak[i]+n;
        }
        for(int s=0 ; s<m ; s++) {
        	helper(s, s+m, -1, weaks, dist, new boolean[dist.length], 0);
        }
        return ret==Integer.MAX_VALUE?-1:ret;
    }
	public void helper(int s, int e, int point, int[] weaks, int[] dist, boolean[] visit, int cnt) {
		while(s<e && weaks[s]<=point) {
			s++;
		}
		if(s>=e) {
			ret = Math.min(ret, cnt);
			return;
		}
		if(cnt>=visit.length) return;
		for(int i=0 ; i<visit.length ; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			helper(s, e, weaks[s]+dist[i], weaks, dist, visit, cnt+1);
			visit[i] = false;
		}
		return;
	}
}
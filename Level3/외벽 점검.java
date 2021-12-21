class 외벽_점검 {
    private int ret;
    public int solution(int n, int[] weak, int[] dist) {
        ret = n+1;
		int[] w = new int[weak.length*2];
		int idx = 0;
        // 역방향 계산하기 짜증나서 만들어 버림.
		while(idx<w.length) {
			if(idx<weak.length) w[idx] = weak[idx];
			else w[idx] = n+weak[idx-weak.length];
			idx++;
		}
		for(int i=0 ; i<weak.length ; i++) {
			helper(w, dist, new boolean[dist.length], n, i, weak.length+i, 0);
		}
		return ret>n?-1:ret;
    }
	
	public void helper(int[] weak, int[] dist, boolean[] visit, int n, int start, int end, int sum) {
		if(start>=end) {
			ret = Math.min(ret, sum);
			return;
		}
		for(int i=0; i<dist.length ; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			int idx = start+1;			
			while(idx<end && (weak[idx]-weak[start])<=dist[i] ) {
				idx++;
			}
			helper(weak, dist, visit, n, idx, end, sum+1);
			visit[i] = false;
		}
		return;
	}
}
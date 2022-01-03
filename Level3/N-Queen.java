class N_Queen {
    public int solution(int n) {
        return helper(new int[n], new boolean[n], 0);
    }
    
    public int helper(int[] arr, boolean[] visit, int cnt) {
		if(cnt==arr.length) {			
			return 1;
		}
		
		int ret = 0;
		
		for(int i=0; i<visit.length ; i++) {
			if(visit[i]) continue;
			boolean corr = true;
			arr[cnt] = i;
			for(int j=0 ; j<cnt ; j++) {
				if(Math.abs(cnt-j)==Math.abs(arr[cnt]-arr[j])) {
					corr = false;
					break;
				}
			}
			
			if(!corr) continue;
			visit[i] = true;
			ret += helper(arr, visit, cnt+1);
			visit[i] = false;
		}
		return ret;
	}
    
}
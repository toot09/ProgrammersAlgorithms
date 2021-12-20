class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int stone : stones) {
			max = Math.max(max, stone);
			min = Math.min(min, stone);
		}
		while(min < max) {
			int mid = (max+min+1)/2;
			if(checkMid(mid, k, stones)) {
				max = mid-1;
			} else {
				min = mid;
			}
		}
		return min;
    }
    
    public boolean checkMid(int mid, int k, int[] stones) {
		int cnt=0;
		for(int stone : stones) {
			if(stone<mid) cnt++;
			else cnt = 0;
			
			if(cnt==k) return true;
			
		}
		return false;
	}
    
}
class 스티커_모으기_2 {
    public int solution(int sticker[]) {
        if(sticker.length==1) return sticker[0];
        return Math.max(helper(0, sticker.length-1, sticker), helper(1,sticker.length , sticker));
    }
    
    public int helper(int s, int e, int[] sticker) {
		int[] dp = new int[sticker.length];
		int ret = 0;
		for(int i=s ; i<e ; i++) {
			if(i-2>=0) dp[i] = dp[i-2];
			if(i-3>=0) dp[i] = Math.max(dp[i-3], dp[i]);
			dp[i] += sticker[i];
			ret = Math.max(dp[i], ret);
		}
		return ret;
	}
    
}
class expressionNumber {
    public int solution(int n) {
        int[] dp = new int[n+1];
        int ret=0, s=0;
        for(int i=1 ; i<=n ; i++) {
            dp[i] = (dp[i-1]+i);
            while(dp[i]-dp[s]>=n) {
                if(dp[i]-dp[s]==n) ret++;
                s++;
            }
        }
        return ret;
    }
}
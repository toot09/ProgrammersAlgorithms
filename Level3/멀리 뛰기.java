class 멀리_뛰기 {
    public long solution(int n) {
        int div = 1234567;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n ; i++) {
            dp[i] = (dp[i] + (i>=2?dp[i-2]:0))%div;
            dp[i] = (dp[i] + (i>=1?dp[i-1]:0))%div;
        }
        return dp[n];
    }
}
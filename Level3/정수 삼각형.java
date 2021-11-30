class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer=0, len=triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        for(int i=0 ; i<len-1 ; i++) {
            for(int j=0 ; j<=i ; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]+triangle[i+1][j+1]);
            }
        }
        for(int i=0 ; i<len ; i++) {
            answer = Math.max(answer, dp[len-1][i]);
        }
        return answer;
    }
}
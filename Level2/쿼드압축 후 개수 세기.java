class 쿼드압축후개수세기 {
    private int[] ret;
    public int[] solution(int[][] arr) {
        ret = new int[]{0,0};
        int m = arr.length, n=arr[0].length;
        int[][] dp = new int[m][n];
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                dp[i][j] = (j==0?0:dp[i][j-1]) + arr[i][j];
            }
        }
        helper(0,0,m-1,n-1,dp);
        return ret;
    }

    public void helper(int si, int sj, int ei, int ej, int[][] dp) {
        int sum = 0;
        for(int i=si ; i<=ei ; i++) {
            sum += (dp[i][ej] - (sj==0?0:dp[i][sj-1]));
        }
        if(sum==0 || sum==(ei-si+1)*(ei-si+1)) {
            ret[(sum==0?0:1)]++;
            return;
        }
        int div = (ei-si)/2;
        helper(si, sj, si+div, sj+div, dp);
        helper(si+div+1, sj, ei, sj+div, dp);
        helper(si, sj+div+1, si+div, ej, dp);
        helper(si+div+1, sj+div+1, ei, ej, dp);
        return;
    }
}
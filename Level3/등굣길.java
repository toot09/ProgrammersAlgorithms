class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int div =  1000000007;
		int[][] move = new int[][]{{1,0},{0,1}};
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		
		for(int[] p : puddles) {
			dp[p[1]-1][p[0]-1] = -1;
		}
	
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(dp[i][j]==-1) continue;
				for(int[] mv : move) {
					if(check(i+mv[0], j+mv[1], dp)) {
						dp[i+mv[0]][j+mv[1]] = (dp[i+mv[0]][j+mv[1]]+dp[i][j])%div;
					}
				}
			}
		}

		return dp[n-1][m-1]%div;
	}
    
    public boolean check(int i, int j, int[][] dp) {
		if(i<0 || i>=dp.length || j<0 || j>=dp[0].length || dp[i][j]==-1) return false;
		else return true;
	}
    
}
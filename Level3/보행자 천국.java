class 보행자_천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
		dp[0][0] = 1;
		
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				
				if(i==0 && j==0) continue;
                // 0일때만 기록한다.
				if(cityMap[i][j]==0) {
					// 왼쪽에서
					dp[i][j] = (dp[i][j]+getNum(cityMap, dp, i, j-1, false))%MOD;
					// 위에서
					dp[i][j] = (dp[i][j]+getNum(cityMap, dp, i-1, j, true))%MOD;
				}
			}
		}		
		return dp[m-1][n-1];
    }
    
    public int getNum(int[][] cityMap, int[][] dp, int i, int j, boolean up) {
		if(i<0 || i>=dp.length || j<0 || j>=dp[0].length || cityMap[i][j]==1) {
			return 0;
		}
		
		if(cityMap[i][j]==0) {
			return dp[i][j];
		} 
		
		int iMinus=0, jMinus=0;
        // 다음 2(조건통행)가 나올때까지 탐색
		while(i-iMinus-(up?1:0) >= 0 && j-jMinus-(up?0:1) >= 0 && cityMap[i-iMinus][j-jMinus]==2) {
			iMinus+=(up?1:0);
			jMinus+=(up?0:1);
		}
		
		return dp[i-iMinus][j-jMinus];
	}
    
}
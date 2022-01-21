class 파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int m=board.length, n=board[0].length, ret=0;
		int[][] sum = new int[m+1][n+1];
		for(int[] s : skill) {
			int i1=s[1],j1=s[2];
			int i2=s[3],j2=s[4];
			int d=s[5]*(s[0]==1?-1:1);
			sum[i1][j1] += d;
			sum[i2+1][j1] += d*-1;
			sum[i1][j2+1] += d*-1;
			sum[i2+1][j2+1] += d;
		}
		// 좌->우
		for(int j=1 ; j<n ; j++) {
			for(int i=0 ; i<m ; i++) {
				sum[i][j] += sum[i][j-1];
			}
		}
		// 상->하
		for(int i=1; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				sum[i][j] += sum[i-1][j];
			}
		}
		// 누적합
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(board[i][j]+sum[i][j]>0) ret++;
			}
		}
		return ret;
    }
}
class 보행자_천국 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[] hor = new int[n];
        int[] ver = new int[m];
        hor[0] = 1;
        ver[0] = 1;
        for(int i=0 ; i<m ; i++) {
        	for(int j=0 ; j<n ; j++) {
        		if((i==0 && j==0)||(cityMap[i][j]==2)) continue;
        		if(cityMap[i][j]==1) {
        			hor[j] = 0;
        			ver[i] = 0;
        		} else {
	        		int sum = (hor[j]+ver[i])%20170805;
	        		hor[j] = sum;
	        		ver[i] = sum;
        		}
        	}
        }
        return ver[m-1];
    }
}
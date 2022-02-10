import java.util.*;
class REDO_경주로_건설 {
    public int solution(int[][] board) {
        int m=board.length, n=board[0].length, MAX=700*m*n;
		int[][] hor = new int[m][n];
		int[][] ver = new int[m][n];
		int[][] move = new int[][]{{0,-1}, {0,1}, {-1,0}, {1,0}};;
		Queue<int[]> q = new LinkedList<>();
		for(int i=0 ; i<m ; i++) {
			Arrays.fill(hor[i], MAX);
			Arrays.fill(ver[i], MAX);
		}
		hor[0][0] = 0;
		ver[0][0] = 0;
		q.offer(new int[]{0,0});
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int i=0 ; i<4 ; i++) {
				int mvi=p[0]+move[i][0], mvj=p[1]+move[i][1];
				
				if(invalidCost(board, mvi, mvj)) {
					continue;
				}
				
				int straight = (i<2?hor[p[0]][p[1]]:ver[p[0]][p[1]])+100;
				int corner = (i<2?ver[p[0]][p[1]]:hor[p[0]][p[1]])+600;
				int minCost = Math.min(straight, corner);
				int[][] dp = (i<2?hor:ver);
				
				if(dp[mvi][mvj]>minCost) {
					dp[mvi][mvj] = minCost;
					q.offer(new int[]{mvi, mvj});
				}
				
			}
		}
		return Math.min(hor[m-1][n-1], ver[m-1][n-1]);
    }
	
	public boolean invalidCost(int[][] board, int i, int j) {
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]==1) return true;
		return false;
	}
}
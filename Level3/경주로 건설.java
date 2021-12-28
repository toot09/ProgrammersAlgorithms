import java.util.*;
class 경주로건설 {
    public int solution(int[][] board) {
        int m=board.length, n=board[0].length;
		int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		int[][] hor = new int[m][n];
		int[][] ver = new int[m][n];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0 ; i<m ; i++) {
			Arrays.fill(hor[i], m*n*500);
			Arrays.fill(ver[i], m*n*500);
		}
		hor[0][0] = 0;
		ver[0][0] = 0;
		q.offer(new int[] {0,0});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int d=0 ; d<4 ; d++) {
				int i=p[0]+dir[d][0], j=p[1]+dir[d][1];
				boolean insert=false;
				if(!helper(i, j, board)) continue;
				
				if(ver[i][j] > (d<2?hor[p[0]][p[1]]+500:ver[p[0]][p[1]])+100) {
					insert = true;
					ver[i][j] = ( d<2 ? hor[p[0]][p[1]]+500 : ver[p[0]][p[1]] )+100;
				}
				if(hor[i][j] > (d>=2?ver[p[0]][p[1]]+500:hor[p[0]][p[1]])+100) {
					insert = true;
					hor[i][j] = (d>=2?ver[p[0]][p[1]]+500:hor[p[0]][p[1]])+100;
				}
				if(insert) q.offer(new int[] {i, j});
			}
		}
		return Math.min(hor[m-1][n-1], ver[m-1][n-1]);
    }
    
    public boolean helper(int i, int j, int[][] board) {
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]==1) return false;
		return true;
	}
    
}
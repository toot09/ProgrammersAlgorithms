import java.util.*;
class 블록_이동하기 {
    public int solution(int[][] board) {
        int m=board.length, n=board[0].length, cnt=0;
		// visit은 최소 값의 좌표로 체크한다.
		// 0:hor/1:ver
        boolean[][][] visit = new boolean[2][m][n];
        Queue<int[]> q = new LinkedList<>();
        // i1, j1, i2, j2, 0:hor/1:ver
        q.offer(new int[]{0,0,0,1,0});
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i=0 ; i<size ; i++) {
	        	int[] p = q.poll();
	        	// Range 확인
	        	if(checkMap(p[0], p[1], p[2], p[3], m, n, visit[p[4]], board)) continue;
                // 끝
	        	if(p[2]==m-1 && p[3]==n-1) return cnt;
	        	// visit
	        	visit[p[4]][p[0]][p[1]] = true;
	        	
                q.offer(new int[]{p[0], p[1]-1, p[2], p[3]-1, p[4]});
        		q.offer(new int[]{p[0], p[1]+1, p[2], p[3]+1, p[4]});
        		q.offer(new int[]{p[0]-1, p[1], p[2]-1, p[3], p[4]});
        		q.offer(new int[]{p[0]+1, p[1], p[2]+1, p[3], p[4]});
	        	
	        	if(p[4]==0) {
	        		// hor
	        		int r = p[0];
	        		if(r+1<m && board[r+1][p[1]]==0 && board[r+1][p[3]]==0) {
	        			q.offer(new int[]{r, p[1], r+1, p[1], 1});
	        			q.offer(new int[]{r, p[3], r+1, p[3], 1});
	        		} 
	        		if(r-1>=0 && board[r-1][p[1]]==0 && board[r-1][p[3]]==0) {
	        			q.offer(new int[]{r-1, p[1], r, p[1], 1});
	        			q.offer(new int[]{r-1, p[3], r, p[3], 1});
	        		}
	        		
	        	} else {
	        		// ver
	        		int c = p[1];
	        		if(c+1<n && board[p[0]][c+1]==0 && board[p[2]][c+1]==0) {
	        			q.offer(new int[]{p[0], c, p[0], c+1, 0});
	        			q.offer(new int[]{p[2], c, p[2], c+1, 0});
	        		}
	        		if(c-1>=0 && board[p[0]][c-1]==0 && board[p[2]][c-1]==0) {
	        			q.offer(new int[]{p[0], c-1, p[0], c, 0});
	        			q.offer(new int[]{p[2], c-1, p[2], c, 0});
	        		}
	        	}
	        	
        	}
        	cnt++;
        }
        return -1;
    }
    public boolean checkMap(int i1, int j1, int i2, int j2, int m, int n, boolean[][] visit, int[][] board) {
		if(i1<0 || i2>=m || j1<0 || j2>=n || visit[i1][j1]) return true;
		else if(board[i1][j1]==1 || board[i2][j2]==1) return true;
		return false;
	}
}
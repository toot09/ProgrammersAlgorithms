import java.util.*;
class 퍼즐_조각_채우기 {
    // 회전 블록 4개	
	private List<int[][][]> blocks;
	// 시작지점, 필요 블록갯수
	private List<int[][]> blanks;
	// 리턴 최대 블록 수
	private int retBlocks;
    public int solution(int[][] game_board, int[][] table) {
        blocks = new ArrayList<>();
		blanks = new ArrayList<>();
		retBlocks = 0;
		// 블록 종류 구하기
		getBlocks(table);
		// 빈칸 구하기
		getBlanks(game_board);
		// 최대값 구하기
		getMaxBlock(game_board, 0, new boolean[blocks.size()], 0);
		
		return retBlocks;
    }
    public void getMaxBlock(int[][] game_board, int idxBlank, boolean[] visit, int cnt) {
		if(idxBlank>=blanks.size()) {
			retBlocks = Math.max(retBlocks, cnt);
			return;
		}
		int[][] blank = blanks.get(idxBlank);
		int m=blank.length, n=blank[0].length, idx=-1;
		boolean cont=true;
		
		while(++idx<blocks.size() && cont) {
			if(visit[idx]) continue;
			
			int[][][] b = blocks.get(idx);
			if( (m*n) !=b[0].length*b[0][0].length) continue;
			
			for(int[][] block : b) {
				if(!(m==block.length && n==block[0].length)) continue;
				
				int corr=0, count=0;
				
				for(int i=0 ; i<m ; i++) {
					for(int j=0 ; j<n ; j++) {
						// 같은것이 있는지 확인
						if(block[i][j]==blank[i][j]) corr++;
						// block 갯수 확인
						if(block[i][j]==1) count++;
					}
				}
				// 같은 것이 없다면 꼭 맞는것이다.
				if(corr==0) {
					visit[idx] = true;
					getMaxBlock(game_board, idxBlank+1, visit, cnt+count);
					visit[idx] = false;
					cont=false;
					break;
				}
			}
		}
		
		// 맞는 블록이 없을 때,
		if(idx==blocks.size()) getMaxBlock(game_board, idxBlank+1, visit, cnt);
		
	}
	
	// 빈칸 구하기
	public void getBlanks(int[][] game_board) {
		int m = game_board.length, n = game_board[0].length;
		boolean[][] visit = new boolean[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				
				if(visit[i][j] || game_board[i][j]==1) continue;
				
				int[] p = new int[]{i, j, i, j};
				dfsBlock(i, j, game_board, visit, p, 0);
				
				int r=p[2]-p[0]+1, c=p[3]-p[1]+1;
				int[][] blank = new int[r][c];
				
				for(int x=0 ; x<r ; x++) {
					for(int y=0 ; y<c ; y++) {
						blank[x][y] = game_board[x+p[0]][y+p[1]];
					}
				}				
				// 빈칸 블록 4개
				blanks.add(blank);
			}
		}
		return;
	}
	
	public void getBlocks(int[][] table) {
		int m = table.length, n = table[0].length;
		boolean[][] visit = new boolean[m][n];
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(visit[i][j] || table[i][j]==0) continue;
				int[] p = new int[]{i, j, i, j};
				dfsBlock(i, j, table, visit, p, 1);
				
				int[][][] block = getBlockRound(table, p);
				// 회전 블록 4개
				blocks.add(block);
			}
		}
		return;
	}
	
	public void dfsBlock(int i, int j, int[][] game_board, boolean[][] visit, int[] p, int chkNum) {
		if(i<0 || i>=game_board.length || j<0 || j>=game_board[0].length || visit[i][j] || game_board[i][j]!=chkNum) {
			return;
		}
		visit[i][j] = true;
		
		p[0] = Math.min(p[0], i);
		p[1] = Math.min(p[1], j);
		p[2] = Math.max(p[2], i);
		p[3] = Math.max(p[3], j);
		
		dfsBlock(i+1, j, game_board, visit, p, chkNum);
		dfsBlock(i-1, j, game_board, visit, p, chkNum);
		dfsBlock(i, j+1, game_board, visit, p, chkNum);
		dfsBlock(i, j-1, game_board, visit, p, chkNum);
		
		return;
	}

	public int[][][] getBlockRound(int[][] table, int[] p) {
		int r=p[2]-p[0]+1, c=p[3]-p[1]+1;
		int[][][] piece = new int[4][][];
		piece[0] = new int[r][c];
		piece[1] = new int[c][r];
		piece[2] = new int[r][c];
		piece[3] = new int[c][r];
		for(int i=0 ; i<r ; i++) {
			for(int j=0 ; j<c ; j++) {
				piece[0][i][j] = table[i+p[0]][j+p[1]];
			}
		}
		// roundMatric
		for(int t=1 ; t<4 ; t++) {
			r = piece[t-1].length;
			c = piece[t-1][0].length;
			for(int j=c-1 ; j>=0 ; j--) {
				for(int i=0 ; i<r ; i++) {
					piece[t][c-j-1][i] = piece[t-1][i][j];
				}
			}
		}
		return piece;
	}
}
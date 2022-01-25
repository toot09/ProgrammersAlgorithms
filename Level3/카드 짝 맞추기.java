import java.util.*;
class 카드_짝_맞추기 {
    private Map<Integer, List<Integer>> cardsMap;
	private List<Integer> cardsList;
	private int minStep;
    public int solution(int[][] board, int r, int c) {
        minStep = Integer.MAX_VALUE;
		
		init(board);
		dfs(r, c, board, new boolean[cardsList.size()], 0, 0);
		
		return minStep;
    }
    
    public void init(int[][] board) {
		int m=board.length, n=board[0].length;
		cardsMap = new HashMap<>();
		cardsList = new ArrayList<>();
		for(int i=0 ; i<m ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(board[i][j]==0) continue;
				if(!cardsList.contains(board[i][j])) {
					cardsList.add(board[i][j]);
					cardsMap.put(board[i][j], new ArrayList<>());
				}
				cardsMap.get(board[i][j]).add(i);
				cardsMap.get(board[i][j]).add(j);
			}
		}
		return;
	}
    
    public void dfs(int i, int j, int[][] board, boolean[] visit, int cnt, int step) {

		if(cnt==visit.length) {
			minStep = Math.min(minStep, step);
			return;
		}
		for(int x=0 ; x<visit.length ; x++) {
			if(visit[x]) continue;
			visit[x] = true;
			
			int card = cardsList.get(x);
			List<Integer> p = cardsMap.get(card);
			int i1=p.get(0), j1=p.get(1), i2=p.get(2), j2=p.get(3); 
			int s11 = getDistance(i, j, i1, j1, (i1-i>0?1:-1), (j1-j>0?1:-1), board, 0);
			int s12 = getDistance(i1, j1, i2, j2, (i2-i1>0?1:-1), (j2-j1>0?1:-1), board, 0);
			int s21 = getDistance(i, j, i2, j2, (i2-i>0?1:-1), (j2-j>0?1:-1), board, 0);
			int s22 = getDistance(i2, j2, i1, j1, (i1-i2>0?1:-1), (j1-j2>0?1:-1), board, 0);
			board[i1][j1] = 0;
			board[i2][j2] = 0;
			
			dfs(i2, j2, board, visit, cnt+1, step+s11+s12+2);
			dfs(i1, j1, board, visit, cnt+1, step+s21+s22+2);
			
			board[i1][j1] = card;
			board[i2][j2] = card;
			visit[x] = false;
		}
		return;
	}
    
    public int getDistance(int si, int sj, int ei, int ej, int iPlus, int jPlus, int[][] board, int step) {
		
		if(si<0 || si>=4 || sj<0 || sj>=4) return 20;
		if(si==ei && sj==ej) return step;

		
		int i=si+iPlus, j=sj+jPlus;
		
		int w = Math.min(getDistance(i, sj, ei, ej, iPlus, jPlus, board, step+1), getDistance(si, j, ei, ej, iPlus, jPlus, board, step+1));
		
		while(i>0 && i<3 && board[i][sj]==0) {
			i+=iPlus;
		}
		int wi = getDistance(i, sj, ei, ej, iPlus, jPlus, board, step+1);
		while(j>0 && j<3 && board[si][j]==0) {
			j+=jPlus;
		}
		int wj = getDistance(si, j, ei, ej, iPlus, jPlus, board, step+1);
		return Math.min(w, Math.min(wi, wj));
	}
    
}
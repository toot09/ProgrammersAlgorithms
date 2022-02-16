class REDO_아이템_줍기 {
    private int borderCNT;
	private int[][] dir;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        borderCNT = Integer.MAX_VALUE;
		dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int[][] map = new int[101][101];
        boolean[][] border = new boolean[101][101];
        
        init(map, rectangle, border);
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        helper(map, border, characterX, characterY, itemX, itemY, new boolean[101][101], 0);

        return borderCNT;
    }
    public void helper(int[][] map, boolean[][] border, int cx, int cy, int ix, int iy, boolean[][] visit, int cnt) {
    	if(cx==ix && cy==iy) {
    		borderCNT = Math.min(borderCNT, cnt);
    		return;
    	}
    	for(int[] d : dir) {
    		if(checkRange(cx+d[0], cy+d[1], map, visit, border)) continue;
    		
    		visit[cx+d[0]][cy+d[1]] = true;
    		helper(map, border, cx+d[0]*2, cy+d[1]*2, ix, iy, visit, cnt+1);
    		visit[cx+d[0]][cy+d[1]] = false;
    	}
    }
	
	public boolean checkRange(int i, int j, int[][] map, boolean[][] visit, boolean[][] border) {
		if(i<0 || i>100 || j<0 || j>100 || map[i][j]!=1 || visit[i][j] || !border[i][j]) return true;
		return false;
	}
	
	public void init(int[][] map, int[][] rectangle, boolean[][] border) {
		for(int[] rect : rectangle) {
			int i1=rect[0]*2, j1=rect[1]*2;
			int i2=rect[2]*2, j2=rect[3]*2;
			for(int i=i1 ; i<=i2 ; i++) {
				for(int j=j1 ; j<=j2 ; j++) {
					map[i][j]++;
					if(i==i1 || i==i2 || j==j1 || j==j2) border[i][j] = true;
				}
			}
		}
		return;
	}
}
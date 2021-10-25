class 카카오프렌즈컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[]{0,0};
        boolean[][] visit = new boolean[m][n];
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                int area = getArea(i, j, picture, visit, picture[i][j]);
                if(area > 0) {
                    answer[0]++;
                    answer[1] = Math.max(answer[1], area);
                }
            }
        }
        return answer;
    }
    public int getArea(int i, int j, int[][] picture, boolean[][] visit, int color) {
        if(i<0 || i>=picture.length || j<0 || j>=picture[0].length || picture[i][j]==0 || visit[i][j] || picture[i][j]!=color) return 0;
        visit[i][j] = true;
        return getArea(i+1, j, picture, visit, color)
             + getArea(i-1, j, picture, visit, color)
             + getArea(i, j+1, picture, visit, color)
             + getArea(i, j-1, picture, visit, color)
             + 1;
    }
}
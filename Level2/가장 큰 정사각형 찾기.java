class gjkjsghfind {
    public int solution(int[][] board) {
        int answer = 0;
        int m=board.length;
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<board[i].length ; j++) {
                if(answer==0 && board[i][j]==1) answer = 1;
                if(i==0 || j==0 || board[i][j]==0) continue;
                int num = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]));
                board[i][j] = num+1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        return answer*answer;
    }
}
class REDO_파괴되지_않은_건물 {
    public int solution(int[][] board, int[][] skill) {
        int m=board.length, n=board[0].length, ret=0;
        int[][] matrix = new int[m+1][n+1];
        // [type, r1, c1, r2, c2, degree]
        // type이 1일 경우는 적의 공격을 의미합니다. 건물의 내구도를 낮춥니다.
        // type이 2일 경우는 아군의 회복 스킬을 의미합니다. 건물의 내구도를 높입니다.
        
        for(int[] s : skill) {
            int d = s[5]*(s[0]==1?-1:1);
            matrix[s[1]][s[2]] += d;
            matrix[s[1]][s[4]+1] -= d;
            matrix[s[3]+1][s[2]] -= d;
            matrix[s[3]+1][s[4]+1] += d;
        }
        for(int i=1 ; i<m ; i++) {
            for(int j=0 ; j<=n ; j++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
        for(int j=1; j<n ; j++) {
            for(int i=0 ; i<m ; i++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(board[i][j]+matrix[i][j]>0) ret++;
            }
        }
        return ret;
    }
}
import java.util.*;
class ddddmg {
    int solution(int[][] land) {
        int answer = 0;
        for(int i=1 ; i<land.length ; i++) {
            for(int j=0 ; j<4 ; j++) {
                int num = land[i][j];
                for(int k=0 ; k<4 ; k++) {
                    if(j==k) continue;
                    land[i][j] = Math.max(land[i][j], land[i-1][k]+num);
                }
            }
        }
        for(int i=0 ; i<4 ; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }
}
import java.util.*;
class 모의고사 {
    public int[] solution(int[] answers) {
        int[][] p = new int[3][];
        p[0] = new int[]{1, 2, 3, 4, 5};
        p[1] = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        p[2] = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[3];
        int max = 0;
        for(int i=0 ; i<answers.length ; i++) {
            int answer = answers[i];
            for(int j=0 ; j<3; j++) {
                if(p[j][i%p[j].length]==answer) scores[j]++;
                max = Math.max(max, scores[j]);
            }
        }
        int cnt = 0;
        for(int i=0 ; i<3 ; i++) if(scores[i]==max) cnt++;
        int[] ret = new int[cnt];
        for(int i=2 ; i>=0 ; i--) {
            if(scores[i]==max) ret[--cnt] = i+1;
        }
        return ret;
    }
}
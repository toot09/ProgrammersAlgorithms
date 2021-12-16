import java.util.*;
class 순위 {
    public int solution(int n, int[][] results) {
        int[][] game = new int[n+1][n+1];
				
		for(int[] g : game) {
			Arrays.fill(g, n);
		}
		
		for(int[] result : results) {
			game[result[0]][result[1]] = 1;
		}
		
		// p:경유, s:시작, e:끝
		for(int p=1 ; p<=n ; p++) {
			for(int s=1 ; s<=n ; s++) {
				for(int e=1 ; e<=n ; e++) {
					if(game[s][e] > game[s][p]+game[p][e]) {
						game[s][e] = game[s][p]+game[p][e];
					}
				}
			}
		}
		
		int ret = 0;
		for(int i=1 ; i<=n ; i++) {
			boolean chk = true;
			for(int j=1 ; j<=n ; j++) {
				if(i==j) continue;
				if(game[i][j]==n && game[j][i]==n) {
					chk=false;
					break;
				}
			}
			if(chk) ret++;
		}
		return ret;
    }
}
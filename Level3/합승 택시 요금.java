import java.util.*;
class 합승_택시_요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        for(int[] m : map) {
        	Arrays.fill(m, 100001*n);
        }
        
        for(int[] fare : fares) {
        	int i=fare[0], j=fare[1], cost=fare[2];
        	map[i][j] = Math.min(map[i][j], cost);
        	map[j][i] = Math.min(map[j][i], cost);
        }
        
        for(int via=1 ; via<=n ; via++) {
        	for(int from=1 ; from<=n ; from++) {
        		for(int to=1 ; to<=n ; to++) {
        			if(map[from][to]>map[from][via]+map[via][to]) {
        				map[from][to] = map[from][via]+map[via][to];
        			}
        		}
        	}
        }
      
        int ret = map[s][a] + map[s][b];
        for(int i=1 ; i<=n ; i++) {
        	ret = Math.min(map[s][i]+(i==a?0:map[i][a])+(i==b?0:map[i][b]), ret);
        }
        return ret;
    }
}
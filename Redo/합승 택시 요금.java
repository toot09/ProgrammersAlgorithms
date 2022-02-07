import java.util.*;
class REDO_합승_택시_요금 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] costs = new int[n+1][n+1];
        int ret=Integer.MAX_VALUE;
        for(int[] cost : costs) {
        	Arrays.fill(cost, 100001*n);
        }
        for(int[] fare : fares) {
        	costs[fare[0]][fare[1]] = fare[2];
        	costs[fare[1]][fare[0]] = fare[2];
        }
        for(int i=1 ; i<=n ; i++) {
        	costs[i][i] = 0;
        }
        for(int via=1 ; via<=n ; via++) {
        	for(int i=1 ; i<=n ; i++) {
        		for(int j=1 ; j<=n ; j++) {
        			costs[i][j] = Math.min(costs[i][j], costs[i][via]+costs[via][j]);
        			costs[j][i] = Math.min(costs[j][i], costs[j][via]+costs[via][i]);
        		}
        	}
        }
        for(int p=1 ; p<=n ; p++) {
        	ret = Math.min(ret, costs[p][s]+costs[p][a]+costs[p][b]);
        }
        return ret;
    }
}
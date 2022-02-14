import java.util.*;
class REDO_GPS {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int len = gps_log.length, last = gps_log[len-1];
		int[][] dp = new int[k][n+1];
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=0 ; i<=n ; i++) {
			list.add(new ArrayList<>());
		}
		for(int[] el : edge_list) {
			list.get(el[0]).add(el[1]);
			list.get(el[1]).add(el[0]);
		}
        for(int i=0 ; i<k ; i++) {
            Arrays.fill(dp[i], k+1);
        }
        dp[0][gps_log[0]] = 0;

		for(int i=1 ; i<k ; i++) {
			for(int curr=1 ; curr<=n ; curr++) {
				dp[i][curr] = dp[i-1][curr];
				for(int bef : list.get(curr)) {
					dp[i][curr] = Math.min(dp[i][curr], dp[i-1][bef]);
				}
				if(curr!=gps_log[i]) dp[i][curr]+=1;
			}
		}
		return dp[k-1][last]>k?-1:dp[k-1][last];
    }
}
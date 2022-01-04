import java.util.*;
class gps {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<List<Integer>> list = new ArrayList<>();
		int[][] dp = new int[k][n+1];
		for(int i=0 ; i<=n ; i++) {
			list.add(new ArrayList<>());
		}
		for(int[] ed : edge_list) {
			list.get(ed[0]).add(ed[1]);
			list.get(ed[1]).add(ed[0]);
		}
		
		for(int[] arr : dp) {
			Arrays.fill(arr, k+1);
		}
		dp[0][gps_log[0]] = 0;
		
		for(int i=1 ; i<k ; i++) {
			for(int j=1 ; j<=n ; j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
				for(int num : list.get(j)) {
					dp[i][j] = Math.min(dp[i][j], dp[i-1][num]);
				}
                dp[i][j] += gps_log[i] == j ? 0 : 1;
			}
		}
		return dp[k-1][gps_log[k-1]]>k?-1:dp[k-1][gps_log[k-1]];
    }
}
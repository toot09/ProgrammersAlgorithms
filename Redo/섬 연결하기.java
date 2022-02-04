import java.util.*;
class REDO_섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];
        int ret = 0;
        for(int i=0 ; i<n ; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (a,b)->{
            return a[2]-b[2];
        });
        for(int[] cost : costs) {
            int c0=cost[0], c1=cost[1];
            int p0=findParent(parent, c0), p1=findParent(parent, c1);
            if(p0!=p1) {
                ret += cost[2];
                parent[p0] = Math.min(p0, p1);
                parent[p1] = Math.min(p0, p1);
            }
        }
        return ret;
    }
    
    public int findParent(int[] parent, int n) {
        if(parent[n]==n) return n;
        else return findParent(parent, parent[n]);
    }
}
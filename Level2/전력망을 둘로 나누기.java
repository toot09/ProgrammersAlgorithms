import java.util.*;
class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int ret = Integer.MAX_VALUE;
        List<List<Integer>> map = new ArrayList<>();
        
        for(int i=0 ; i<=n ; i++) {
            map.add(new ArrayList<Integer>());
        }
        
        for(int[] wire : wires) {
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }

        for(int[] wire : wires) {
            int m1 = dfs(map, wire[0], wire[0], wire[1], new boolean[n+1]);
            ret = Math.min(Math.abs(n-m1-m1), ret);
        }

        return ret;
    }

    public int dfs(List<List<Integer>> map, int start, int i1, int i2, boolean[] visit) {
        if(visit[start]) return 0;
        visit[start] = true;
        int ret = 1;
        List<Integer> list = map.get(start);
        for(int i : list) {
            if((start==i1 && i==i2) || (start==i2 && i==i1)) continue;
            ret += dfs(map, i, i1, i2, visit);
        }
        return ret;
    }
}
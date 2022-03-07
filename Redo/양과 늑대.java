import java.util.*;
class REDO_양과_늑대 {
    // info	                    edges	                                                                result
    // [0,0,1,1,1,0,1,0,1,0,1,1]	[[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]	5
    // [0,1,0,1,1,0,1,0,0,1,0]	    [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]          5
    private Map<Integer, List<Integer>> hm;
    private int ret;
    public int solution(int[] info, int[][] edges) {
        hm = new HashMap<>();
        ret = 0;
        for(int[] edge : edges) {
            if(!hm.containsKey(edge[0])) hm.put(edge[0], new ArrayList<>());
            hm.get(edge[0]).add(edge[1]);
        }
        helper(info, new ArrayList<>(), 0, 0, 0);
        return ret;
    }
    public void helper(int[] info, List<Integer> list, int w, int s, int node) {
        // 0은 양, 1은 늑대를 의미합니다.
        if(info[node]==0) s++;
        else w++;
        
        if(s<=w) return;
        ret = Math.max(ret, s);
        
        List<Integer> next = new ArrayList<>();
        next.addAll(list);
        next.remove(Integer.valueOf(node));
        
        if(hm.containsKey(node)) next.addAll(hm.get(node));
        
        for(int n : next) {
            helper(info, next, w, s, n);
        }
        
        return;
    }
}
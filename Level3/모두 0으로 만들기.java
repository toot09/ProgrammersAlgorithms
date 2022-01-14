import java.util.*;
class 모두_0으로_만들기 {
    private long ret;
	private Map<Integer, List<Integer>> hm;
    
    public long solution(int[] a, int[][] edges) {
        hm = new HashMap<>();
		ret = 0;
        boolean[] visit = new boolean[a.length];
		for(int[] e : edges) {
			if(!hm.containsKey(e[0])) hm.put(e[0], new ArrayList<>());
			hm.get(e[0]).add(e[1]);
			if(!hm.containsKey(e[1])) hm.put(e[1], new ArrayList<>());
			hm.get(e[1]).add(e[0]);
		}
		return helper(visit, a, 0)!=0?-1:ret;
	}
	
	public long helper(boolean[] visit, int[] a, int i) {
		visit[i] = true;
		long num = (long)a[i];
		for(int idx : hm.get(i)) {
			if(visit[idx]) continue;
			num += helper(visit, a, idx);
		}
		ret += Math.abs(num);
		return num;
    }
    
}
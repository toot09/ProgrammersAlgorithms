import java.util.*;
class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int ret = 0;
        int[] parent = new int[n];
        for(int i=0 ; i<n ; i++) {
        	parent[i] = i;
        }
        Arrays.sort(costs, (a,b)->{
        	return a[2]-b[2];
        });
        for(int i=0 ; i<costs.length ; i++) {
        	int p0 = find(parent,costs[i][0]), p1 = find(parent,costs[i][1]);
        	if(p0 != p1) {
        		ret += costs[i][2];
        		kruskal(parent, costs[i][0], costs[i][1], Math.min(p0, p1));
        	}
        }
        return ret;
	}
	
	public void kruskal(int[] parent, int n1, int n2, int p) {
		int p1 = find(parent, n1);
		int p2 = find(parent, n2);
		parent[p1] = p;
		parent[p2] = p;
		return;
	}
	
	public int find(int[] parent, int n) {
		if(parent[n]==n) return n;
		else return find(parent, parent[n]);
	}
}
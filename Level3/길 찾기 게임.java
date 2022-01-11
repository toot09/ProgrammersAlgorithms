import java.util.*;
class 길_찾기_게임 {
    private List<Integer> ver;
	private Map<Integer, int[]> hor;
	private List<Integer> pre;
	private List<Integer> post;
    public int[][] solution(int[][] nodeinfo) {
        ver = new ArrayList<>();
		hor = new HashMap<>();
		pre = new ArrayList<>();
		post = new ArrayList<>();
		int[][] ret = new int[2][nodeinfo.length];
		
		for(int i=0 ; i<nodeinfo.length ; i++) {
			 int[] info = nodeinfo[i];
			 if(!ver.contains(info[1])) {
				 ver.add(info[1]);
				 hor.put(info[1], new int[100001]);
			 }
			 hor.get(info[1])[info[0]] = i+1;
		 }
		 Collections.sort(ver);
		 helper(ver.size()-1, 0, 100000);
		 
		 for(int i=0; i<pre.size() ; i++) {
			 ret[0][i] = pre.get(i);
		 }
		 for(int i=0; i<post.size() ; i++) {
			 ret[1][i] = post.get(i);
		 }
		 return ret;
    }
    
    public void helper(int depth, int s, int e) {
		if(depth<0) return;
		int[] arr = hor.get(ver.get(depth));
		for(int i=s ; i<=e ; i++) {
			if(arr[i]>0) {
				pre.add(arr[i]);
				//left
				helper(depth-1, s, i-1);
				//right
				helper(depth-1, i+1, e);
				post.add(arr[i]);
			}
		}
		return;
	}
    
}
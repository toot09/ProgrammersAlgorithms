import java.util.*;
class REDO_길_찾기_게임 {
    public int[][] solution(int[][] nodeinfo) {
        int[][] nodes = new int[nodeinfo.length][3];
		int[][] ret = new int[2][nodeinfo.length];
		int max = 0;
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		
		for(int i=0 ; i<nodeinfo.length ; i++) {
			nodes[i][0] = nodeinfo[i][0];
			nodes[i][1] = nodeinfo[i][1];
			nodes[i][2] = i+1;
			max = Math.max(max, nodeinfo[i][0]);
		}
		
		Arrays.sort(nodes, (a,b)->{
			if(a[1]!=b[1]) return b[1]-a[1];
			else return a[0]-b[0];
		});
		
		searchNodes(nodes, list, 0, max, 0);

		for(int i=0 ; i<ret[0].length ; i++) {
			ret[0][i] = list.get(0).get(i);
			ret[1][i] = list.get(1).get(i);
		}
		return ret;
    }
	
	public void searchNodes(int[][] nodes, List<List<Integer>> list, int start, int end, int idx) {
		for(int i=idx ; i<nodes.length ; i++) {
			if(start<=nodes[i][0] && nodes[i][0]<=end) {
				// preorder
				list.get(0).add(nodes[i][2]);
				
				// left
				searchNodes(nodes, list, start, nodes[i][0]-1, i+1);
				// right
				searchNodes(nodes, list, nodes[i][0]+1, end, i+1);
				
				// postorder
				list.get(1).add(nodes[i][2]);
				
				break;
			}
		}
		return;
	}
}
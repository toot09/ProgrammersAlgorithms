import java.util.*;
class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for(int[] node : edge) {
            if(!hm.containsKey(node[0])) hm.put(node[0], new ArrayList<Integer>());
            if(!hm.containsKey(node[1])) hm.put(node[1], new ArrayList<Integer>());
            List<Integer> n0=hm.get(node[0]), n1=hm.get(node[1]);
            if(!n0.contains(node[1])) n0.add(node[1]);
            if(!n1.contains(node[0])) n1.add(node[0]);
        }
        int size = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visit = new boolean[n+1];
        visit[1] = true;
        while(!q.isEmpty()) {
            size = q.size();
            for(int i=1 ; i<=size ; i++) {
                int node = q.poll();
                List<Integer> connList = hm.get(node);
                for(int conn : connList)  {
                    if(visit[conn]) continue;
                    visit[conn] = true;
                    q.offer(conn);
                }
            }
        }
        return size;
    }
}
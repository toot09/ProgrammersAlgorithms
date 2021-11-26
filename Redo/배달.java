import java.util.*;
class 배달 {
    private Map<Integer, Map<Integer, Integer>> hm;
    public int solution(int N, int[][] road, int K) {
        hm = new HashMap<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        Set<Integer> hs = new HashSet<>();
        hs.add(1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        for(int[] r : road) {
            int loc1=r[0], loc2=r[1], d=r[2];
            helper(loc1, loc2, d);
            helper(loc2, loc1, d);
        }
        while(!q.isEmpty()) {
            int from = q.poll();
            Map<Integer, Integer> distMap = hm.get(from);
            for(Map.Entry<Integer, Integer> e : distMap.entrySet()) {
                int loc = e.getKey(), d = e.getValue();
                if(dist[from]+d<dist[loc]) {
                    dist[loc] = dist[from]+d;
                    //System.out.println("from : "+from+" / loc : "+loc+" / dist : "+dist[loc]);
                    if(dist[loc] <= K) {
                        hs.add(loc);
                        q.offer(loc);
                    }
                }
            }
        }
        return hs.size();
    }
    public void helper(int loc1, int loc2, int d) {
        if(!hm.containsKey(loc1)) hm.put(loc1, new HashMap<>());
        Map<Integer, Integer> hm1 = hm.get(loc1);
        if(!hm1.containsKey(loc2)) hm1.put(loc2, d);
        else hm1.put(loc2, Math.min(hm1.get(loc2), d));
        return;
    }
}
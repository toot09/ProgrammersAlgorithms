import java.util.*;
class delivery {
    public int solution(int N, int[][] road, int K) {
        Set<Integer> hs = new HashSet<>();
        hs.add(1);
        int[] visit = new int[N+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[1] = 0;
        int[][] dists = new int[N+1][N+1];
        for(int i=0 ; i<road.length ; i++) {
            int t1=road[i][0], t2=road[i][1], d=road[i][2];
            dists[t1][t2] = dists[t1][t2]==0?d:Math.min(dists[t1][t2], d);
            dists[t2][t1] = dists[t2][t1]==0?d:Math.min(dists[t2][t1], d);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1 ; i<=size ; i++) {
                int town = q.poll();
                int[] dist = dists[town];
                for(int j=1 ; j<dist.length ; j++) {
                    if(dist[j]==0) continue;
                    if(visit[town]+dist[j]<visit[j] && visit[town]+dist[j]<=K) {
                        q.offer(j);
                        visit[j] = visit[town]+dist[j];
                        hs.add(j);
                    }
                }
            }
        }
        return hs.size();
    }
}
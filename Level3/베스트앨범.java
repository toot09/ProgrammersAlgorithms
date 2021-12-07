import java.util.*;
class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> tot = new HashMap<>();
        Map<String, List<Integer>> list = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            return tot.get(b)-tot.get(a);
        });
        for(int i=0 ; i<genres.length ; i++) {
            String g = genres[i];
            tot.put(g, tot.getOrDefault(g,0)+plays[i]);
            if(!list.containsKey(g)) {
                list.put(g, new ArrayList<>());
            }
            list.get(g).add(i);
        }
        int len = 0;
        for(String key : tot.keySet()) {
            pq.offer(key);
            len += Math.min(list.get(key).size(),2);
        }
        int[] ret = new int[len];
        int idx = 0;
        while(!pq.isEmpty()){
            List<Integer> l = list.get(pq.poll());
            Collections.sort(l, (a,b)->{
                return plays[b]-plays[a];
            });
            for(int i=0 ; i<2 && i<l.size() ; i++) {
                ret[idx++] = l.get(i);
            }
        }
        return ret;
    }
}
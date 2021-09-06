import java.util.*;
class printer {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=0 ; i<priorities.length ; i++) {
            q.offer(i);
            pq.offer(priorities[i]);
        }
        int ret=1;
        while(!q.isEmpty()) {
            while(pq.peek()!=priorities[q.peek()]) {
                q.offer(q.poll());
            }
            pq.poll();
            if(location == q.poll()) break;
            ret++;
        }
        return ret;
    }
}
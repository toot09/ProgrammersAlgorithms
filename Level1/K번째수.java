import java.util.*;
class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0 ; i<commands.length ; i++) {
            int[] command = commands[i];
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                return b-a;
            });
            for(int j=command[0]-1 ; j<command[1] ; j++) {
                pq.offer(array[j]);
                if(pq.size()>command[2]) pq.poll();
            }
            answer[i] = pq.poll();
        }
        return answer;
    }
}
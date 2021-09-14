import java.util.*;
class drthrowtruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int weight_sum=0, idx=0, time=0;
        Queue<int[]> q = new LinkedList<>();
        while(!q.isEmpty() || idx<truck_weights.length) {
            if(!q.isEmpty() && time-q.peek()[1]>=bridge_length) {
                weight_sum -= q.poll()[0];
            }
            if(idx<truck_weights.length && weight_sum+truck_weights[idx]<=weight) {
                weight_sum += truck_weights[idx];
                q.offer(new int[]{truck_weights[idx++],time});
            }
            time++;
        }
        return time;
    }
}
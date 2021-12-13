import java.util.*;
class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int ret=0, cnt=0, idx=0, end=0;
        Arrays.sort(jobs, (a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        while(cnt<jobs.length) {
            while(idx<jobs.length && jobs[idx][0]<=end) {
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                ret += (job[1]+end-job[0]);
                end += job[1];
                cnt++;
            }
        }
        return ret/jobs.length;
    }
}
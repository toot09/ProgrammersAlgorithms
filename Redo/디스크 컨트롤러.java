import java.util.*;
class REDO_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int sum=0, start=0, idx=0;
		Arrays.sort(jobs, (a,b)->{
			return a[0]-b[0];
		});
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
			return a[1]-b[1];
		});
		while(idx<jobs.length || !pq.isEmpty()) {
			while(idx<jobs.length && jobs[idx][0]<=start) {
				pq.offer(jobs[idx++]);
			}
			if(pq.isEmpty()) {
				start = jobs[idx][0];
			} else {
				int[] disk = pq.poll();
				sum += (disk[1]+start-disk[0]);
				start += disk[1];
			}
		}
		return sum/jobs.length;
    }
}
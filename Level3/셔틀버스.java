import java.util.*;
class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        int rideTime=9*60, lastTime=rideTime+(n-1)*t;
        int lastCrew = 0, cnt = 0;
		
        PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0 ; i<timetable.length ; i++) {
			String[] time = timetable[i].split(":");
			pq.offer(Integer.valueOf(time[1])+Integer.valueOf(time[0])*60);
        }
		
		while(!pq.isEmpty() && rideTime<=lastTime) {
			cnt = 0;
			for(; cnt<m && !pq.isEmpty() && pq.peek()<=rideTime ; cnt++) {
				lastCrew = pq.poll();
			}
			rideTime += t;
		}
		
		return cnt==m?getTImeString(lastCrew-1):getTImeString(lastTime);
    }
	
	public String getTImeString(int time) {
		StringBuilder sb = new StringBuilder();
		if(time/60<10) sb.append("0");
		sb.append(time/60);
		sb.append(":");
		if(time%60<10) sb.append("0");
		sb.append(time%60);
		return sb.toString();
	}
}
import java.util.*;
class REDO_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String ret = "";
		int start=convTimeToInt("09:00");
        int[] busTime = new int[timetable.length];
        Arrays.sort(timetable);
        for(int i=0 ; i<timetable.length ; i++) {
        	busTime[i] = convTimeToInt(timetable[i]);
        }
        int ride=0, idx=0;
        while(n-->0) {
        	ride = 0;
        	while(ride<m && idx<busTime.length && busTime[idx]<=start) {
        		idx++;
        		ride++;
        	}
        	if(n>0) start += t;
        }
        if(ride<m) ret = convIntToTime(start);
        else ret = convIntToTime(busTime[idx-1]-1);
        
        return ret;
    }
    public String convIntToTime(int time) {
		StringBuilder sb = new StringBuilder();
		int hour = time/60;
		time %= 60;
		
		if(hour<10) sb.append(0);
		sb.append(hour);
		sb.append(":");
		if(time<10) sb.append(0);
		sb.append(time);
		
		return sb.toString();
	}
	
	public int convTimeToInt(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*60+Integer.valueOf(t[1]);
	}
}
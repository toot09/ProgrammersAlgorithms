class 광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime=getTimetoSec(play_time), advTime=getTimetoSec(adv_time);
		int[] timeLine = new int[playTime+1];
        
        for(int i=0 ; i<logs.length ; i++) {
        	String[] log = logs[i].split("-");
        	int start = getTimetoSec(log[0]);
        	int end = getTimetoSec(log[1]);
        	for(int t=start ; t<end ; t++) {
        		timeLine[t]++;
        	}
        }
     
        long maxLen=0;
        int start=0, end=advTime;
        for(int i=0 ; i<end ; i++) {
        	maxLen += timeLine[i];
        }
        
        long tmpLen=maxLen;
        int ret=0;
        
        while(end<=playTime) {
        	tmpLen += timeLine[end];
        	tmpLen -= timeLine[start];
        	if(tmpLen>maxLen) {
        		maxLen = tmpLen;
        		ret = start+1;
        	}
        	start++;
        	end++;
        }
        return getSectoTime(ret);
    }
    
    public int getTimetoSec(String time) {
		String[] t = time.split(":");
		return Integer.valueOf(t[0])*3600+Integer.valueOf(t[1])*60+Integer.valueOf(t[2]);
	}
	
	public String getSectoTime(int time) {
		StringBuilder sb = new StringBuilder();
		int hour = time/3600;
		time %= 3600;
		int min = time/60;
		time %= 60;
		int sec = time;
		
		return sb.append(hour<10?"0":"").append(hour).append(":").append(min<10?"0":"").append(min).append(":").append(sec<10?"0":"").append(sec).toString();
	}
}
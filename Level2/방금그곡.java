class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String ret = "(None)";
        int len = 0;
        m = getMelody(m);
        
        for(String music : musicinfos) {
            String[] info = music.split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            int time = Integer.valueOf(end[0])*60 + Integer.valueOf(end[1]) - (
                Integer.valueOf(start[0])*60 + Integer.valueOf(start[1])
            ) + 1;
            String melody = getMelody(info[3]);
            int leadTime = time;
            StringBuilder sb = new StringBuilder();
            while(leadTime-melody.length() > 0) {
                sb.append(melody);
                leadTime -= melody.length();
            }
            sb.append(melody.substring(0, leadTime));
            if(sb.indexOf(m)!=-1 && len<time) {
                len = time;
                ret = info[2];
            }
        }
        return ret;
    }
    
    public String getMelody(String m) {
        m = m.replace("C#", "H");
        m = m.replace("D#", "I");
        m = m.replace("F#", "J");
        m = m.replace("G#", "K");
        m = m.replace("A#", "L");
        return m;
    }
}
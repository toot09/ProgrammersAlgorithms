class cstraffic {
    public int Solution(String[] lines) {
        String[] time = new String[lines.length];
        for(int i=0 ; i<lines.length ; i++) {
            lines[i] = lines[i].substring(11).replace(":","").replace("s", "");
            int t = Integer.valueOf(lines[i].substring(0,2))*3600 + Integer.valueOf(lines[i].substring(2,4))*60 + Integer.valueOf(lines[i].substring(4,6));
            time[i] = ""+t+lines[i].substring(6);
        }
        int ret = 0;
        for(int i=0 ; i<time.length ; i++) {
            String[] split = time[i].split(" ");
            Double area = Double.valueOf(split[0]) + 1;
            int cnt = 1;
            for(int j=i+1 ; j<time.length ; j++) {
                String[] tmp = time[j].split(" ");
                Double start = Double.valueOf(tmp[0]) - Double.valueOf(tmp[1]) + 0.001;
                if(start<area) cnt++;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }
}
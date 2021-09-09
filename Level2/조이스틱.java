class joystick {
    private int seriesRight = 0;
    private int seriesLeft = 0;
    private int[] series;
    public int solution(String name) {
        // [length, start Index]
        series = new int[]{0,0};
        int[] tmp = new int[]{0,0};
        for(int i=0 ; i<name.length() ; i++) {
            char c = name.charAt(i);
            if(c=='A') {
                if(tmp[0]==0) tmp[1] = i;
                tmp[0]++;
            } else {
                if(series[0]<tmp[0]) {
                    series[0] = tmp[0];
                    series[1] = tmp[1];
                }
                tmp[0] = 0;
            }
        }
        int right = getSteps(name,0,0,0,true);
        int left = getSteps(name,0,0,0,false);
        int seriesLen = Integer.MAX_VALUE;
        if(series[0]>0) {
            seriesLen = seriesRight + seriesLeft + Math.min(series[1]-1, name.length() - (series[0]+series[1]));
        }
        return Math.min(seriesLen, Math.min(right, left));
    }
    public int getSteps(String name, int idx, int step, int cnt, boolean right) {
        if(idx>=name.length() || (idx==0 && step>0)) {
            return cnt;
        }
        int n = name.charAt(idx)-'A';
        n = Math.min(n, 26-n);
        if(n>0) {
            cnt += (step+n);
            step = 0;
        }
        if(right && series[0]>0 && idx==series[1]-1) {
            seriesRight = cnt;
        }
        if(!right && series[0]>0 && idx==series[1]+series[0]) {
            seriesLeft = cnt;
        }
        return getSteps(name, right?idx+1:(idx==0?name.length()-1:idx-1), step+1, cnt, right);
    }
}

// 테스트 1 〉	통과 (0.04ms, 70.5MB)
// 테스트 2 〉	통과 (0.06ms, 72.9MB)
// 테스트 3 〉	통과 (0.04ms, 59.9MB)
// 테스트 4 〉	통과 (0.03ms, 71.4MB)
// 테스트 5 〉	통과 (0.06ms, 71.3MB)
// 테스트 6 〉	통과 (0.03ms, 70.3MB)
// 테스트 7 〉	통과 (0.06ms, 72.7MB)
// 테스트 8 〉	통과 (0.04ms, 70.6MB)
// 테스트 9 〉	통과 (0.03ms, 69.6MB)
// 테스트 10 〉	통과 (0.05ms, 73.7MB)
// 테스트 11 〉	통과 (0.03ms, 59.2MB)
class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] p = new int[n];
        for(int l : lost) {
            p[l-1]--;
        }
        for(int r : reserve) {
            p[r-1]++;
        }
        int ret = 0;
        for(int i=0 ; i<p.length ; i++) {
            if(p[i]<0) {
                if(i>0 && p[i-1]>0) {
                    p[i-1]--;
                    p[i]++;
                    ret++;
                } else if(i<p.length-1 && p[i+1]>0) {
                    p[i+1]--;
                    p[i]++;
                    ret++;
                }
            } else {
                ret++;
            }
        }
        return ret;
    }
}
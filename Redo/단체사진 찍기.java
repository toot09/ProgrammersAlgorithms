class 단체사진찍기 {
    public int solution(int n, String[] data) {
        String[] chs = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visit = new boolean[8];
        return helper(data, chs, visit, "");
    }
    
    public int helper(String[] data, String[] chs, boolean[] visit, String line) {
        for(String d : data) {
            int i1=line.indexOf(d.charAt(0)), i2=line.indexOf(d.charAt(2));
            char sign=d.charAt(3);
            if(i1==-1 || i2==-1) {
                continue;
            }
            double n = d.charAt(4)-'0', diff=Math.abs(i1-i2)-1;
            if(sign=='=' && n!=diff) {
                return 0;
            } else if(sign=='<' && diff>=n) {
                return 0;
            } else if(sign=='>' && diff<=n) {
                return 0;
            }
        }
        int ret = 0;
        if(line.length() == chs.length) {
            return 1;
        }
        for(int i=0; i<visit.length ; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            ret += helper(data, chs, visit, line+chs[i]);
            visit[i] = false;
        }
        return ret;
    }
    
}
class 피로도 {
    private int ret = 0;
    public int solution(int k, int[][] dungeons) {
        helper(k, dungeons, new boolean[dungeons.length], 0);
        return ret;
    }
    public void helper(int k, int[][] dungeons, boolean[] visit, int count) {
        if(count>=visit.length) {
            ret = count;
            return;
        }
        for(int i=0 ; i<dungeons.length ; i++) {
            if(visit[i]) continue;
            if(k<dungeons[i][0]) {
                ret = Math.max(ret, count);
                continue;
            }
            visit[i] = true;
            helper(k-dungeons[i][1], dungeons, visit, count+1);
            visit[i] = false;
        }
        return;
    }
}
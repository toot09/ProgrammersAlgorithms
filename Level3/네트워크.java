class 네트워크 {
    private boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            int len = dfs(computers, i);
            if(len>0) answer++;
        }
        return answer;
    }
    public int dfs(int[][] computers, int n) {
        if(visit[n]) {
            return 0;
        }
        int ret = 1;
        visit[n] = true;
        for(int i=0 ; i<computers.length ; i++) {
            if(i==n || computers[n][i]==0) continue;
            ret += dfs(computers, i);
        }
        return ret;
    }
}
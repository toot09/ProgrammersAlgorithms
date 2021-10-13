class 거리두기확인하기 {
    public int[] solution(String[][] places) {
        int[] ret = new int[places.length];
        for(int x=0 ; x<places.length ; x++) {
            String[] place = places[x];
            boolean[][] visit = new boolean[5][5];
            ret[x] = 1;
            for(int i=0 ; i<5 ; i++) {
                for(int j=0 ; j<5 ; j++) {
                    if(visit[i][j] || place[i].charAt(j)!='P') continue;
                    if(helper(place, i, j, 0, visit)) {
                        ret[x] = 0;
                    }
                    if(ret[x]==0) break;
                }
                if(ret[x]==0) break;
            }
        }
        return ret;
    }
    public boolean helper(String[] place, int i, int j, int cnt, boolean[][] visit) {
        if(i<0 || i>=5 || j<0 || j>=5 || visit[i][j] || place[i].charAt(j)=='X') return false;
        visit[i][j] = true;
        if(cnt>0 && cnt<=2 && place[i].charAt(j)=='P') {
            return true;
        }
        if(cnt==2) return false;
        return helper(place, i+1, j, cnt+1, visit)||helper(place, i-1, j, cnt+1, visit)||helper(place, i, j+1, cnt+1, visit)||helper(place, i, j-1, cnt+1, visit);
    }
}
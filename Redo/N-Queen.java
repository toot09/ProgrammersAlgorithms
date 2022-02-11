import java.util.*;
class REDO_N_QUEEN {
    private int ret;
    public int solution(int n) {
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        boolean[] visit = new boolean[n];
        getQueen(0, visit, diagonal1, diagonal2);
        return ret;
    }
	
	public void getQueen(int cnt, boolean[] visit, Set<Integer> diagonal1, Set<Integer> diagonal2) {
		if(cnt>=visit.length) {
			ret++;
			return;
		}
		for(int i=0 ; i<visit.length ; i++) {
			if(visit[i]) continue;
			int d1=cnt-i, d2=i+cnt;
			if(diagonal1.contains(d1) || diagonal2.contains(d2)) continue;
			visit[i] = true;
			diagonal1.add(d1);
			diagonal2.add(d2);
			getQueen(cnt+1, visit, diagonal1, diagonal2);
			visit[i] = false;
			diagonal1.remove(d1);
			diagonal2.remove(d2);
		}
		return;
	}
}
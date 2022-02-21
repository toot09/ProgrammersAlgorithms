class REDO_공_이동_시뮬레이션 {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        int si=x, ei=x, sj=y, ej=y;
		for(int i=queries.length-1 ; i>=0 ; i--) {
			int d=queries[i][0], step=queries[i][1];
			
			if(d==0) {
				// Right
				ej = Math.min(m-1, ej+step);
				if(sj>0) sj+=step;
			} else if(d==1) {
				// Left
				sj = Math.max(0, sj-step);
				if(ej<m-1) ej-=step;
			} else if(d==2) {
				// Down
				ei = Math.min(n-1, ei+step);
				if(si>0) si+=step;
			} else {
				// Up
				si = Math.max(0, si-step);
				if(ei<n-1) ei-=step;
			}
			
			if(si>ei || ei<si || sj>ej || ej<sj) return 0;
		}
        
		return (long)(ei-si+1)*(long)(ej-sj+1);
    }
}
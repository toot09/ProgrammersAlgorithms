class 풍선터트리기 {
    public int solution(int[] a) {
        int len=a.length, ret=0;
		int[] forward = new int[len];
		int[] backward = new int[len];
		for(int i=0 ; i<len ; i++) {
			forward[i] = Math.min(a[i], i==0?Integer.MAX_VALUE:forward[i-1]);
		}
		for(int i=len-1 ; i>=0 ; i--) {
			backward[i] = Math.min(a[i], i==len-1?Integer.MAX_VALUE:backward[i+1]);
		}
		for(int i=0 ; i<len ; i++) {
			if(forward[i]==a[i] || backward[i]==a[i]) {
				ret++;
			}
		}
		return ret;
    }
}
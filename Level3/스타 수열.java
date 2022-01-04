class 스타_수열 {
    public int solution(int[] a) {
        int[] count = new int[a.length];
        for(int num : a) count[num]++;
        
        int ret = 0;
        
        for(int i=0 ; i<a.length ; i++) {
        	if(count[i]==0) continue;
        	if(count[i]<=ret) continue;
        	int len = 0;
        	for(int j=0 ; j<a.length-1 ; j++) {
        		if(a[j]!=i && a[j+1]!=i) continue;
        		if(a[j]==a[j+1]) continue;
        		len++;
        		j++;
        	}
        	ret = Math.max(ret, len);
        }
        
        return ret*2;
    }
}
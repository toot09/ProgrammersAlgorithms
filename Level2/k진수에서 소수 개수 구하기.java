class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int ret = 0;
		StringBuilder sb = new StringBuilder();
        while(n>0) {
        	sb.append(n%k);
        	n /= k;
        }
        sb.reverse();
        String[] nums = sb.toString().split("0");
        
        for(String num : nums) {
        	if(num.equals("")) continue;
        	if(helper(Long.valueOf(num))) ret++;
        }
        
        return ret;
    }
    public boolean helper(long num) {
		if(num==1) return false;
		int max = (int)Math.sqrt(num);
		for(int i=2 ; i<=max ; i++) {
			if(num%i==0) return false;
		}
		return true;
	}
}
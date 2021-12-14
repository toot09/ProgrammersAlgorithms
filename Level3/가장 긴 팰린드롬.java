class 가장_긴_팰린드롬 {
    public int solution(String s) {
        int ret = 1;
		for(int i=0 ; i<s.length()-1; i++) {
			int len = Math.max(helper(i, i, s), helper(i, i+1, s));
			ret = Math.max(ret, len);
		}
		return ret;
    }
    public int helper(int s, int e, String str) {
		while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)) {
			s--;
			e++;
		}
		return e-s-1;
	}
}
class nextbiggernum {
    public int solution(int n) {
        int cnt = getOneCount(n);
        n++;
        while(getOneCount(n)!=cnt) {
            n++;
        }
        return n;
    }
    public int getOneCount(int n) {
        int ret = 0;
        String s = Integer.toBinaryString(n);
        for(int i=0 ; i<s.length() ; i++) {
            if(s.charAt(i)=='1') ret++;
        }
        return ret;
    }
}
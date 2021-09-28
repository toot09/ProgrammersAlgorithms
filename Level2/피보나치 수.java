class fibonazzi {    
    public int solution(int n) {
        if(n<=1) return n;
        int pre=0, cur=1;
        for(int i=2; i<=n ;i++) {
            int num = (pre+cur)%1234567;
            pre = cur;
            cur = num;
        }
        return cur;
    }
}
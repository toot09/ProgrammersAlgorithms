class 약수의합 {
    public int solution(int n) {
        int mid = (int)Math.sqrt(n);
        int ret = 0;
        for(int i=1 ; i<=mid ; i++) {
            if(n%i==0) {                
                ret += i;
                if(i*i!=n) ret += (n/i);
            }
        }
        return ret;
    }
}
class 정수제곱근판별 {
    public long solution(long n) {
        double d = Math.sqrt(n);
        if(d%1==0) return (long)Math.pow(d+1, 2);
        return -1;
    }
}
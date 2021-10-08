class 소수찾기 {
    public int solution(int n) {
        boolean[] nonPrimes = new boolean[n+1];
        int ret = n;
        for(int i=2 ; i<=n/2 ; i++) {
            for(int j=2 ; j*i<=n ; j++) {
                if(!nonPrimes[i*j]) {
                    nonPrimes[i*j] = true;
                    ret -= 1;
                }
            }
        }
        return ret-1;
    }
}
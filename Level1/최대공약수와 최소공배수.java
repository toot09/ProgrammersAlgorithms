class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        if(n>m) return solution(m, n);
        int g = gcd(m, n);
        return new int[]{g, (m*n)/g};
    }
    public int gcd(int n1, int n2) {
        while(n2>0) {
            int mod = n1%n2;
            n1 = n2;
            n2 = mod;
        }
        return n1;
    }
}
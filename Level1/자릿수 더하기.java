class 자릿수더하기 {
    public int solution(int n) {
        int ret = 0;
        while(n>0) {
            ret += (n%10);
            n /= 10;
        }
        return ret;
    }
}
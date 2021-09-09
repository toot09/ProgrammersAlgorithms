class ysEntry {
    public int solution(int n, int a, int b) {
        if(a>b) return solution(n,b,a);
        int answer = 1;
        while(!(a%2==1 && a==b-1)) {
            answer++;
            a = a/2 + a%2;
            b = b/2 + b%2;
        }
        return answer;
    }
}
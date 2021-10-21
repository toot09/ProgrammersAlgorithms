class 나머지가1이되는수찾기 {
    public int solution(int n) {
        int answer = 2;
        n -= 1;
        while(answer<=n && n%answer!=0) {
            answer++;
        }
        return answer;
    }
}
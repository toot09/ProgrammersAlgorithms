class 삼진법뒤집기 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            sb.append(n%3);
            n /= 3;
        }
        int answer = 0, three = 1;
        for(int i=sb.length()-1 ; i>=0 ; i--) {
            int num = sb.charAt(i)-'0';
            answer += (num*three);
            three *= 3;
        }
        return answer;
    }
}
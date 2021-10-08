class 수박수박수박수박수박수 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>=2) {
            sb.append("수박");
            n -= 2;
        }
        return sb.toString()+(n==1?"수":"");
    }
}
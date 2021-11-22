class 일이사나라의숫자 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            int num = (n-1)%3+1;
            num = num==3?4:num;
            sb.append(num);
            n = (n-1)/3;
        }
        return sb.reverse().toString();
    }
}
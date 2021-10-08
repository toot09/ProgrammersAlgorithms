class 문자열을정수로바꾸기 {
    public int solution(String s) {
        int num=0, sign=1;
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c=='-' || c=='+') {
                if(c=='-') sign = -1;
                continue;
            }
            num *= 10;
            num += c-'0';
        }
        return num*sign;
    }
}
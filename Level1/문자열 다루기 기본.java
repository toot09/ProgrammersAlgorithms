class 문자열다루기기본 {
    public boolean solution(String s) {
        if(s.length()!=4 && s.length()!=6) return false;
        for(int i=0 ; i<s.length() ; i++) {
            int n = s.charAt(i)-'0';
            if(n<0 || n>9) return false;
        }
        return true;
    }
}
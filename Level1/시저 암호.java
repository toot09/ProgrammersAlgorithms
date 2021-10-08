class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c==' ') {
                sb.append(c);
            } else {
                char comp = 'A';
                if(Character.isLowerCase(c)) comp = 'a';
                int num = c-comp+n;
                if(num>25) num %= 26;
                sb.append((char)(comp+num));
            }
        }
        return sb.toString();
    }
}
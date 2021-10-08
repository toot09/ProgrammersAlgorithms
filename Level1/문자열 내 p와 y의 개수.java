class 문자열내p와y의개수 {
    boolean solution(String s) {
        int sum = 0;
        for(int i=0 ; i<s.length() ; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if(c=='p') sum++;
            if(c=='y') sum--;
        }
        return sum==0;
    }
}
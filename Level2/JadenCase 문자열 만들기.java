class jadencase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(i==0 || s.charAt(i-1)==' ')
                sb.append(Character.toUpperCase(c));
            else 
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
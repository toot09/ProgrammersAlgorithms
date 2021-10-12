class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        for(int i=1 ; i<=len-4 ; i++) {
            sb.append("*");
        }
        return sb.toString()+phone_number.substring(len-4, len);
    }
}
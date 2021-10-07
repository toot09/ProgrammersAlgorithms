class 가운데글자가져오기 {
    public String solution(String s) {
        int i1=(s.length()-1)/2, i2=s.length()/2;
        return s.substring(i1,i2+1);
    }
}
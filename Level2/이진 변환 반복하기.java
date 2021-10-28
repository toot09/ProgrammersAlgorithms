class 이진변환반복하기 {
    public int[] solution(String s) {
        int cnt = 0, countZero = 0;
        while(!s.equals("1")) {
            int befLen = s.length();
            s = s.replace("0","");
            cnt++;
            countZero += (befLen-s.length());
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{cnt, countZero};
    }
}
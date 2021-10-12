class 이천016년 {
    public String solution(int a, int b) {
        int[] mon = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        String[] week = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};    
        for(int i=1 ; i<a ; i++) {
            b+=mon[i];
        }
        return week[b%7];
    }
}
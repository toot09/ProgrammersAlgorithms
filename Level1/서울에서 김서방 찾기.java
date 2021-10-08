class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int idx=0;
        while(idx<seoul.length && !seoul[idx].equals("Kim")) {
            idx++;
        }
        return "김서방은 "+idx+"에 있다";
    }
}
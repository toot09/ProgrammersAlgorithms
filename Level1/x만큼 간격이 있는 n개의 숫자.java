class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0 ; i<n ; i++) {
            answer[i] = (i==0?0:answer[i-1])+x;
        }
        return answer;
    }
}
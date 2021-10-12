class 콜라츠추측 {
    public int solution(int num) {
        int cnt = 0;
        while(num>1 && cnt<500) {
            if(num%2==1) {
                num *= 3;
                num += 1;
            } else {
                num /= 2;
            }
            cnt++;
        }
        return (cnt>=500||num<0)?-1:cnt;
    }
}
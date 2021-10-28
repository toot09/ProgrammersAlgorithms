class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] ret = new long[numbers.length];
        for(int i=0 ; i<numbers.length ; i++) {
            long tmp = numbers[i];
            int idx = 0;
            while(tmp>0) {
                if(tmp%2==0) break;
                tmp /= 2;
                idx++;
            }
            ret[i] = numbers[i]+(long)Math.pow(2,idx)-(idx>0?(long)Math.pow(2,idx-1):0);
        }
        return ret;
    }
}
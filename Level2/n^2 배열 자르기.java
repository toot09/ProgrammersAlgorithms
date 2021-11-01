class n2배열자르기 {
    public int[] solution(int n, long left, long right) {
        int[] ret = new int[(int)(right-left)+1];
        int cnt = 0;
        while(left<=right) {
            int min = (int)(left/n)+1;
            ret[cnt++] = (int)Math.max(min, left%n+1);
            left++;
        }
        return ret;
    }
}
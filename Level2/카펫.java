class carpet {
    public int[] solution(int brown, int yellow) {
        int tot = brown+yellow;
        int[] ret = new int[]{0,0};
        for(int i=3 ; i<tot/2 ; i++) {
            if(tot%i!=0) continue;
            int j = tot/i;
            if(2*i+2*j-4 == brown) {
                ret[0] = j;
                ret[1] = i;
                break;
            }
        }
        return ret;
    }
}
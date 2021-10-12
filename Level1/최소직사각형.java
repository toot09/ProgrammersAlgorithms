class 최소직사각형 {
    public int solution(int[][] sizes) {
        int l1=0, l2=0;
        for(int[] size : sizes) {
            int tmp1=size[0], tmp2=size[1];
            if(size[0]>size[1]) {
                tmp1 = size[1];
                tmp2 = size[0];
            }
            l1 = Math.max(l1, tmp1);
            l2 = Math.max(l2, tmp2);
        }
        return l1*l2;
    }
}
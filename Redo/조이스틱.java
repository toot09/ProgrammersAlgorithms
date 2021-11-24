class 조이스틱 {
    public int solution(String name) {
        int[] alpha = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[] steps = new int[name.length()];
        for(int i=0 ; i<name.length() ; i++) {
            steps[i] = alpha[name.charAt(i)-'A']+(i==0?0:steps[i-1]);
        }
        int min = name.length()-1;
        int idx = 0;
        while(idx<name.length()) {
            if(name.charAt(idx)=='A') {
                int start = idx;
                while(idx+1<name.length() && name.charAt(idx+1)=='A') {
                    idx++;
                }
                int forward = (start==0?0:(start-1));
                int backward = (idx==name.length()-1?0:(name.length()-1-(idx+1)));
                min = Math.min(min, forward+backward+Math.min(forward,backward)+1);
            }
            idx++;
        }
        return steps[name.length()-1]+min;
    }
}
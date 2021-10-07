class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0 ; i<n ; i++) {
            String s1 = getBinary(arr1[i], n);
            String s2 = getBinary(arr2[i], n);
            StringBuilder sb = new StringBuilder();
            for(int j=0 ; j<n ; j++) {
                if(s1.charAt(j)=='1' || s2.charAt(j)=='1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public String getBinary(int num, int n) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        while(s.length()+sb.length() < n) {
            sb.append("0");
        }
        return sb.toString()+s;
    }
}
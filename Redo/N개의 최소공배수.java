class N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1 ; i<arr.length ; i++) {
            int e = ecd(answer, arr[i]);
            answer = answer*arr[i]/e;
        }
        return answer;
    }
    public int ecd(int a, int b) {
        int mod = a%b;
        if(mod==0) {
            return b;
        } else {
            return ecd(b, mod);
        }
    }
}
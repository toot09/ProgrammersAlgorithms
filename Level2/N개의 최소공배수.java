class Ngcsgbs {
    public int solution(int[] arr) {
        int ret = arr[0];
        for(int i=1 ; i<arr.length ; i++) {
            int g = helper(ret, arr[i]);
            ret = (ret*arr[i])/g;
        }
        return ret;
    }
    public int helper(int a, int b) {
        if(b>a) return helper(b,a);
        while(b!=0) {
            int mod = a%b;
            a = b;
            b = mod;
        }
        return a;
    }
}
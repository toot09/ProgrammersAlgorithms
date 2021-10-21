class 멀쩡한사각형 {
    public long solution(int w, int h) {
        if(w>h) return solution(h, w);        
        long answer = (long)w*h;
        long sum = 0, minus = h;
        for(int i=1 ; i<=h ; i++) {
            sum += w;
            if(sum>h) {
                minus+=1;
            }
            sum %= h;
        }
        return answer-minus;
    }
}

// class Solution {
//     public long solution(int w, int h) {
//         int gcd = gcd(w,h);
//         return (long)w*h - (w+h-gcd);
//     }
//     public int gcd(int a, int b) {
//         while(b>0) {
//             int mod = a%b;
//             a = b;
//             b = mod;
//         }
//         return a;
//     }
// }
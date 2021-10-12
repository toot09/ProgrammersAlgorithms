import java.util.*;
class 정수내림차순으로배치하기 {
    public long solution(long n) {
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        long ret = 0;
        for(int i=c.length-1 ; i>=0 ; i--) {
            ret *= 10;
            ret += (c[i]-'0');
        }
        return ret;
    }
}
import java.util.*;
class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        
        int[] ret = new int[sb.length()];
        for(int i=sb.length()-1 ; i>=0 ; i--) {
            ret[sb.length()-1-i] = (sb.charAt(i)-'0');
        }
        return ret;
    }
}
import java.util.*;
class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b)->{
            if(a.charAt(n)!=b.charAt(n)) {
                return a.charAt(n)-b.charAt(n);
            } else {
                return a.compareTo(b);
            }
        });
        return strings;
    }
}
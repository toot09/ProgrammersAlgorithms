import java.util.*;
class csmdg {
    public String solution(String number, int k) {
        char[] num = new char[number.length()-k];
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<number.length() ; i++) {
            char c = number.charAt(i);
            while(!s.isEmpty() && s.peek()<c && k-->0) {
                s.pop();
            }
            s.push(c);
        }
        while(s.size()>num.length) s.pop();
        for(int i=num.length-1 ; i>=0 ; i--) {
            num[i] = s.pop();
        }
        return String.valueOf(num);
    }
}
import java.util.*;
class 큰수만들기 {
    public String solution(String number, int k) {
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<number.length() ; i++) {
            char c = number.charAt(i);
            while(!s.isEmpty() && s.peek()<c && k>0) {
                k--;
                s.pop();
            }
            s.push(c);
        }
        while(k-->0) {
            s.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}
import java.util.*;
class 괄호변환 {
    public String solution(String p) {
        int o=0, i=0;
        while(i<p.length()) {
            char c = p.charAt(i++);
            if(c=='(') o++;
            else o--;
            if(o==0) break;
        }
        if(o!=0 || p.equals("")) return p;
        String u = p.substring(0, i);
        String v = p.substring(i, p.length());
        if(!ynCorrect(u)) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            return sb.append(reverseString(u)).toString();
        } 
        return u+solution(v);
    }

    public String reverseString(String u) {
        StringBuilder sb = new StringBuilder();
        for(int i=1 ; i<u.length()-1 ; i++) {
            char c = u.charAt(i);
            if(c=='(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }

    public boolean ynCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(c==')') {
                if(stack.isEmpty() || stack.pop()!='(') return false;
            } else {
                stack.push('(');
            }
        }
        return stack.isEmpty();
    }
}
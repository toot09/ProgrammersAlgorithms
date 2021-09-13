import java.util.*;
class ghhjhg {
    private Map<Character, Character> hm = new HashMap<>();
    public int solution(String s) {
        int ret = 0;
        if(s.length()%2 == 1) return ret;
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<s.length() ; i++) {
            sb.append(s.charAt(i));
        }
        for(int i=0 ; i<s.length() ; i++) {
            if(helper(sb)) ret++;
            char c = sb.charAt(0);
            sb.deleteCharAt(0).append(c);
        }
        return ret;
    }
    
    public boolean helper(StringBuilder sb) {
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<sb.length() ; i++) {
            char c = sb.charAt(i);
            if(hm.containsKey(c)) {
                if(s.isEmpty() || s.pop()!=hm.get(c)) return false;
            } else {
                s.push(c);
            }
        }
        return s.isEmpty();
    }
}
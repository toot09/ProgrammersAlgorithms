import java.util.*;
class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(stack.size()>0 && stack.peek()==c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size()>0?0:1;
    }
}
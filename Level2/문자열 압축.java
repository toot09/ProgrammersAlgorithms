// Difficulty : 2
// Comment : Easy but Complex
// url : https://programmers.co.kr/learn/courses/30/lessons/60057?language=java#


import java.util.*;
class mjyac {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1 ; i<=s.length()/2 ; i++) {
            int len = helper(s, i);
            answer = Math.min(len, answer);
        }
        return answer;
    }
    public int helper(String s, int len) {
        int idx=0, cnt=1;
        String pre="";
        StringBuilder sb = new StringBuilder();
        while(idx+len<=s.length()) {
            if(pre.equals("")) {
                pre = s.substring(idx, idx+len);
            } else {
                String tmp = s.substring(idx, idx+len);
                if(pre.equals(tmp)) {                    
                    cnt++;
                } else {
                    if(cnt>1) sb.append(String.valueOf(cnt));
                    sb.append(pre);
                    pre = tmp;
                    cnt = 1;
                }
            }
            idx += (len);
        }
        if(cnt>1) sb.append(String.valueOf(cnt));
        sb.append(pre);
        if(idx<s.length()) sb.append(s.substring(idx, s.length()));
        return sb.length();
    }
}
import java.util.*;
class gjks {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if(a.length()==b.length()) return Integer.valueOf(b)-Integer.valueOf(a);
            int len = 0;
            while(len<a.length() || len<b.length()) {
                char ca = (len>=a.length() ? a.charAt(0):a.charAt(len));
                char cb = (len>=b.length() ? b.charAt(0):b.charAt(len));
                if(ca!=cb) return cb-ca;
                len++;
            }
            String tmp = a.length()>b.length()?a:b;
            char cf=tmp.charAt(tmp.length()-2), cb=tmp.charAt(tmp.length()-1);
            if(cf>cb) {
                return a.length()-b.length();
            } else {
                return b.length()-a.length();    
            }
        });
        for(int num : numbers) pq.offer(String.valueOf(num));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            String n = pq.poll();
            if(sb.length()==0 && n.equals("0")) continue;
            sb.append(n);
        }
        return sb.length()==0?"0":sb.toString();
    }
}

/*
테스트 1 〉	통과 (134.98ms, 88.8MB)
테스트 2 〉	통과 (102.62ms, 67.1MB)
테스트 3 〉	통과 (122.01ms, 73.9MB)
테스트 4 〉	통과 (12.23ms, 75.3MB)
테스트 5 〉	통과 (186.17ms, 70.9MB)
테스트 6 〉	통과 (71.88ms, 84.4MB)
테스트 7 〉	통과 (0.96ms, 77.8MB)
테스트 8 〉	통과 (0.73ms, 75.4MB)
테스트 9 〉	통과 (0.87ms, 69MB)
테스트 10 〉	통과 (1.07ms, 70.7MB)
테스트 11 〉	통과 (1.15ms, 72.6MB)
*/

//=== 간단하지만 시간이 좀 걸리는 버전 ===
/*
import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            return Integer.valueOf(b+a)-Integer.valueOf(a+b);
        });
        for(int num : numbers) pq.offer(String.valueOf(num));
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            String n = pq.poll();
            if(sb.length()==0 && n.equals("0")) continue;
            sb.append(n);
        }
        return sb.length()==0?"0":sb.toString();
    }
}


테스트 1 〉	통과 (322.05ms, 117MB)
테스트 2 〉	통과 (201.04ms, 97.2MB)
테스트 3 〉	통과 (384.26ms, 150MB)
테스트 4 〉	통과 (27.69ms, 79.4MB)
테스트 5 〉	통과 (276.96ms, 118MB)
테스트 6 〉	통과 (201.30ms, 99.3MB)
테스트 7 〉	통과 (3.54ms, 72MB)
테스트 8 〉	통과 (2.47ms, 76MB)
테스트 9 〉	통과 (3.58ms, 71.6MB)
테스트 10 〉	통과 (3.09ms, 71.2MB)
테스트 11 〉	통과 (4.10ms, 58.8MB)
*/
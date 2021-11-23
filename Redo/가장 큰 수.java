import java.util.*;
class 가장큰수 {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            int len = Math.max(a.length(), b.length());
            for(int i=0 ; i<len ; i++) {
                char ca = (i>=a.length()?a.charAt(0):a.charAt(i));
                char cb = (i>=b.length()?b.charAt(0):b.charAt(i));
                if(ca==cb) continue;
                return cb - ca;
            }
            return b.charAt(b.length()-1)-a.charAt(a.length()-1);
        });
        for(int num : numbers) {
            pq.offer(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.charAt(0)=='0'?"0":sb.toString();
    }
}
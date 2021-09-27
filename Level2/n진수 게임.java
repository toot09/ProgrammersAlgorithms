import java.util.*;
class njsgame {
    public String solution(int n, int t, int m, int p) {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(10,"A");
        hm.put(11,"B");
        hm.put(12,"C");
        hm.put(13,"D");
        hm.put(14,"E");
        hm.put(15,"F");
        int org = 0, rot = 1;
        StringBuilder sb = new StringBuilder();
        while(t>0) {
            StringBuilder tmp = new StringBuilder();
            int num = org;
            while(num / n > 0) {
                tmp.insert(0, (num%n>=10 ? hm.get(num%n) : num%n));
                num /= n;
            }
            tmp.insert(0, (num>=10 ? hm.get(num) : num));
            for(int i=0 ; i<tmp.length() ; i++) {
                if(t<=0) break;
                if((m==p && rot%m==0) || rot%m==p) {
                    sb.append(tmp.charAt(i));
                    t--;
                }
                rot++;
            }
            org++;
        }
        return sb.toString();
    }
}
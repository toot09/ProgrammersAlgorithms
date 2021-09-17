import java.util.*;
class bmge {
    public int solution(String dirs) {
        
      Set<String> hs = new HashSet<>();
      Map<Character, Integer> hm = new HashMap<>();
      hm.put('U', 1);
      hm.put('D', -1);
      hm.put('R', 1);
      hm.put('L', -1);
      int x = 0, y = 0, len = 0;
      for(int i = 0; i < dirs.length(); i++) {
           //System.out.println("x : " + x + " / y : " + y);
           char dir = dirs.charAt(i);
           if(dir == 'U' || dir == 'D') {
                if(y + hm.get(dir) < -5 || y + hm.get(dir) > 5) {
                    continue;
                }
                String s1 = new StringBuilder().append(x).append(y).append(x).append(y + hm.get(dir)).toString();
                String s2 = new StringBuilder().append(x).append(y + hm.get(dir)).append(x).append(y).toString();
                y += hm.get(dir);
                if(hs.contains(s1) || hs.contains(s2)) {
                    continue;
                }
                hs.add(s1);
                hs.add(s2);
                len++;
           } else {
                if(x + hm.get(dir) < -5 || x + hm.get(dir) > 5) {
                    continue;
                }
                String s1 = new StringBuilder().append(x).append(y).append(x + hm.get(dir)).append(y).toString();
                String s2 = new StringBuilder().append(x + hm.get(dir)).append(y).append(x).append(y).toString();
                x += hm.get(dir);
                if(hs.contains(s1) || hs.contains(s2)) {
                    continue;
                }
                hs.add(s1);
                hs.add(s2);
                len++;
           }
      }
      return len;
    }
}
import java.util.*;
class 다트게임 {
    public int solution(String dr) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('S',1);
        hm.put('D',2);
        hm.put('T',3);
        Set<Character> hs = new HashSet<>();
        hs.add('*');
        hs.add('#');
        int idx = 0, sum = 0, bef = 0;
        for(int i=0 ; i<dr.length() ; i++) {
            int i1 = i;
            while(i<dr.length() && Character.isDigit(dr.charAt(i))) {
                i++;
            }
            int num = (int)Math.pow(Integer.valueOf(dr.substring(i1, i)), hm.get(dr.charAt(i)));
            if((i+1)<dr.length() && hs.contains(dr.charAt(i+1))) {
                i++;
                if(dr.charAt(i)=='#') {
                    num *= -1;
                } else {
                    num *= 2;
                    sum += bef;
                }
            }
            sum += num;
            bef = num;
        }
        return sum;
    }
}
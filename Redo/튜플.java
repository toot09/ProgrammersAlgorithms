import java.util.*;
class 튜플 {
    public int[] solution(String s) {
        s = s.substring(0, s.length()-2).replace("{","");
        List<String[]> list = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        String[] tmp = s.split("},");
        int[] ret = new int[tmp.length];

        for(String t : tmp) {
            list.add(t.split(","));
        }
        Collections.sort(list, (a,b)->{
            return a.length-b.length;
        });
        for(int i=0 ; i<list.size() ; i++) {
            for(String num : list.get(i)) {
                if(hs.add(num)) {
                    ret[i] = Integer.valueOf(num);
                    break;
                }
            }
        }
        return ret;
    }
}
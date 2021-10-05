import java.util.*;
import java.util.Map.*;
class wjhjmh {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hm = new HashMap<>();
        for(String part : participant) {
            hm.put(part, hm.getOrDefault(part,0)+1);
        }
        for(String comp : completion) {
            hm.put(comp, hm.get(comp)-1);
            if(hm.get(comp)==0) hm.remove(comp);
        }
        String ret = "";
        for(Entry<String, Integer> e : hm.entrySet()) {
            ret = e.getKey();
        }
        return ret;
    }
}
import java.util.*;
class 위장 {
    public int solution(String[][] clothes) {
        Map<String, Integer> hm = new HashMap<>();
        for(String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0)+1);
        }
        int ret = 1;
        for(Map.Entry<String, Integer> e : hm.entrySet()) {
            ret *= (e.getValue()+1);
        }
        return ret-1;
    }
}
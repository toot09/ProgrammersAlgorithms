import java.util.*;
class englishgmig {
    public int[] solution(int n, String[] words) {
        Set<String> hs = new HashSet<>();
        hs.add(words[0]);
        int idx=0;
        while(++idx<words.length) {
            String pre = words[idx-1], cur = words[idx];
            if(hs.contains(cur) || pre.charAt(pre.length()-1)!=cur.charAt(0)) {
                return new int[]{idx%n+1, idx/n+1};
            }
            hs.add(cur);
        }
        return new int[]{0,0};
    }
}
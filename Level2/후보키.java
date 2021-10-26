import java.util.*;
class 후보키 {
    private List<String> list = new ArrayList<>();
    public int solution(String[][] relation) {
        String[] words = new String[relation.length];
        Arrays.fill(words, "");
        helper(relation, words, 0, "", new HashSet<String>());
        Collections.sort(list, (a,b)->{
            return a.length()-b.length();
        });
        Set<Integer> dup = new HashSet<>();
        for(int i=0 ; i<list.size()-1 ; i++) {
            String si = list.get(i);
            for(int j=i+1; j<list.size() ; j++) {
                String sj = list.get(j);
                int x = 0;
                while(x<si.length()) {
                    char c = si.charAt(x);
                    if(sj.indexOf(c)==-1) break;
                    x++;
                }
                if(x==si.length()) {
                    dup.add(j);
                }
            }
        }
        return list.size()-dup.size();
    }

    public void helper(String[][] relation, String[] words, int idx, String indice, Set<String> hs) {
        if(idx>=relation[0].length) {
            return;
        }
        for(int i=idx ; i<relation[0].length ; i++) {
            String[] word = words.clone();
            boolean dup = false;
            for(int j=0 ; j<relation.length ; j++) {
                word[j] += "|"+i+relation[j][i];
                if(hs.contains(word[j])) { 
                    dup = true;
                }
                hs.add(word[j]);
            }
            if(!dup) {
                list.add(indice+i);
                continue;
            }
            helper(relation, word, i+1, indice+i, hs);
        }
        return;
    }
}
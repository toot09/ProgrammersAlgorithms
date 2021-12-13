import java.util.*;
class 단어변환 {
    private int ret;
    private Map<String, List<String>> hm = new HashMap<>();
    public int solution(String begin, String target, String[] words) {
        ret = words.length+1;
        hm.put(begin, new ArrayList<>());
        // Begin Setting
        for(int i=0 ; i<words.length ; i++) {
        	hm.put(words[i], new ArrayList<>());
        	if(compare(begin, words[i])) {
        		hm.get(begin).add(words[i]);
        	}
        }        
        // Map Setting
        for(int i=0 ; i<words.length ; i++) {
        	for(int j=i+1 ; j<words.length ; j++) {
        		if(compare(words[i], words[j])) {
            		hm.get(words[i]).add(words[j]);
            		hm.get(words[j]).add(words[i]);
            	}
        	}
        }
        // DFS
        dfs(begin, target, new HashSet<String>(), 0, words.length);
        return ret>words.length?0:ret;
    }
    
    public boolean compare(String s1, String s2) {
		int cnt = 0;
		for(int i=0 ; i<s1.length(); i++) {
			char c1=s1.charAt(i), c2=s2.charAt(i);
			if(c1!=c2) {
				cnt++;
			}
			if(cnt>1) return false;
		}
		return true;
	}
    
    public void dfs(String s, String target, HashSet<String> hs, int cnt, int limit) {
		if(cnt>limit || cnt>ret) {
			return;
		}
		if(s.equals(target)) {
			ret = Math.min(ret, cnt);
			return;
		}
		for(String next : hm.get(s)) {
			if(hs.contains(next)) continue;
			hs.add(next);
			dfs(next, target, hs, cnt+1, limit);
			hs.remove(next);
		}
		return;
	}   
}
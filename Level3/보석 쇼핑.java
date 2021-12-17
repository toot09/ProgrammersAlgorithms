import java.util.*;
class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        Map<String, Integer> hm = new HashMap<>();
		Set<String> hs = new HashSet<>();
        for(String gem : gems) {
        	hs.add(gem);
        }
        int idx=0, cnt=0, len=gems.length;
        int[] ret = new int[]{1, gems.length};
        
        for(int i=0 ; i<gems.length ; i++) {
        	String gem = gems[i];
        	hm.put(gem, hm.getOrDefault(gem, 0)+1);
        	
        	if(hm.get(gem)==1) cnt++;
        	
        	while(cnt==hs.size() && idx<=i) {
        		if(len>(i-idx+1)) {
        			len = i-idx+1;
        			ret[0] = idx+1;
        			ret[1] = i+1;
        		}
        		hm.put(gems[idx], hm.get(gems[idx])-1);
        		if(hm.get(gems[idx++])==0) cnt--;
        	}
        }
        
        return ret;
    }
}
import java.util.*;
class 불량_사용자 {
    public int solution(String[] user_id, String[] banned_id) {
        Map<String, List<String>> hm = new HashMap<>();
		for(String id : user_id) {
			setDict(id, 0, "", hm);
		}
		List<String> ret = new ArrayList<>();
		dfs(banned_id, 0, hm, new HashSet<String>(), new ArrayList<String>(), ret);
		return ret.size();
	}
	
	public void dfs(String[] banned_id, int idx, Map<String, List<String>> hm, Set<String> visit, List<String> list, List<String> ret) {
		if(idx==banned_id.length) {
			Collections.sort(list);
			String l = String.join("|", list);
			if(!ret.contains(l)) {
				ret.add(l);
			}
			return;
		}
		String ban = banned_id[idx];
		for(String id : hm.get(ban)) {
			if(visit.contains(id)) continue;
			visit.add(id);
			list.add(id);
			dfs(banned_id, idx+1, hm, visit, list, ret);
			list.remove(id);
			visit.remove(id);
		}
		return;
	}
	
	public void setDict(String id, int idx, String s, Map<String, List<String>> hm) {
		if(idx==id.length()) {
			if(!hm.containsKey(s)) hm.put(s, new ArrayList<>());
			hm.get(s).add(id);
			return;
		}
		setDict(id, idx+1, s+"*", hm);
		setDict(id, idx+1, s+id.charAt(idx), hm);
		return;
	}
}
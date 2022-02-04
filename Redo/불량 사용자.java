import java.util.*;
class REDO_불량_사용자 {
    private Map<String, List<Integer>> hm;
    private Set<String> ret;
    public int solution(String[] user_id, String[] banned_id) {
        hm = new HashMap<>();
        ret = new HashSet<>();
        for(int i=0 ; i<user_id.length ; i++) {
            settingID(user_id[i], "", 0, i);
        }
        helper(banned_id, 0, new ArrayList<Integer>());
        return ret.size();
    }
    
    public void helper(String[] ban, int idx, List<Integer> list) {
        if(idx==ban.length) {
            Collections.sort(list);
            String concat = concatID(list);
            ret.add(concat);
            return;
        }
        if(hm.containsKey(ban[idx])) {
            for(int id_idx : hm.get(ban[idx])) {
                if(list.contains(id_idx)) continue;
                list.add(id_idx);
                helper(ban, idx+1, list);
                list.remove(Integer.valueOf(id_idx));
            }
        }
        return;
    }
    
    public String concatID(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for(int id : list) {
            sb.append(id);
        }
        return sb.toString();
    }
    
    public void settingID(String ID, String input, int idx, int id_idx) {
        if(ID.length()==idx) {
            if(!hm.containsKey(input)) hm.put(input, new ArrayList<>());
            hm.get(input).add(id_idx);
            return;
        }
        settingID(ID, input+"*", idx+1, id_idx);
        settingID(ID, input+ID.charAt(idx), idx+1, id_idx);
        return;
    }
}
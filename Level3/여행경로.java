import java.util.*;
class 여행경로 {
    Map<String, List<Integer>> hm;
    List<String> list;
    public String[] solution(String[][] tickets) {
        // key : from / value : to index
        hm = new HashMap<>();
        list = new ArrayList<>();
        
        for(int i=0 ; i<tickets.length ; i++) {
            if(!hm.containsKey(tickets[i][0])) {
                hm.put(tickets[i][0], new ArrayList<>());
            }
            hm.get(tickets[i][0]).add(i);
        }
        boolean[] visit = new boolean[tickets.length];
        helper("ICN", tickets, visit, "ICN", 0);
        // 알파벳순 sorting
        Collections.sort(list);
        String[] ret = list.get(0).split(" ");
        return ret;
        
    }
    public void helper(String from, String[][] tickets, boolean[] visit, String sch, int cnt) {
        if(cnt==tickets.length) {
            list.add(sch);
            return;
        }
        if(!hm.containsKey(from)) return;
        List<Integer> des = hm.get(from);
        for(int i=0 ; i<des.size() ; i++) {
            int d = des.get(i);
            if(visit[d]) continue;
            visit[d] = true;
            helper(tickets[d][1], tickets, visit, sch+" "+tickets[d][1],  cnt+1);
            visit[d] = false;
        }
        return;
    }
}
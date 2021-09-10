import java.util.*;
class searchingRank {
    private Map<String, List<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        hm = new HashMap<>();
        //int[] scores = new int[info.length];
        int[] ret = new int[query.length];
        
        for(int i=0 ; i<info.length ; i++) {
            String[] datas = info[i].split(" ");
            //scores[i] = Integer.valueOf(datas[4]);
            setMap(datas, "", 0, Integer.valueOf(datas[4]));
        }
        
        // 점수 정렬
        for(Map.Entry<String, List<Integer>> e : hm.entrySet()) {
            List<Integer> scores = e.getValue();
            Collections.sort(scores);
        }
        
        for(int i=0 ; i<query.length ; i++) {
            String[] q = query[i].replaceAll(" and","").split(" ");
            StringBuilder sb = new StringBuilder();
            //sb.append(q[0]).append(q[1]).append(q[2]).append(q[3]);
            sb.append("");
            if(!q[0].equals("-")) sb.append(q[0]);
            if(!q[1].equals("-")) sb.append(q[1]);
            if(!q[2].equals("-")) sb.append(q[2]);
            if(!q[3].equals("-")) sb.append(q[3]);
            String s = sb.toString();
            
            if(!hm.containsKey(s)) continue;
            
            List<Integer> score = hm.get(s);
            int cutLine = Integer.valueOf(q[4]);
            int start = 0, end = score.size()-1;
            
            // 이분탐색
            while(start<=end) {
                int mid = (start+end)/2;
                if(score.get(mid) < cutLine) {
                    start = mid+1;	
                } else {
                    end = mid-1;
                }
            }
            
            ret[i] = score.size()-start;
        }
        return ret;
    }
    
    public void setMap(String[] datas, String data, int len, int score) {
        if(len==4) {
            insertMap(data, score);
            return;
        }
        setMap(datas, data, len+1, score);
        setMap(datas, data+datas[len], len+1, score);
        return;
    }
    
    public void insertMap(String data, int score) {
        //System.out.println(data);
        if(!hm.containsKey(data)) {
            hm.put(data, new ArrayList<Integer>());
        }
        hm.get(data).add(score);
    }
    
}
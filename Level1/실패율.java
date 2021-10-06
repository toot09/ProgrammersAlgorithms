import java.util.*;
class 실패율 {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        List<Double> rate = new ArrayList<>();
        Map<Double, List<Integer>> hm = new HashMap<>();
        int idx = 0;
        for(int i=1 ; i<=N ; i++) {
            int idx2=idx;
            while(idx2<stages.length && stages[idx2]==i) idx2++;
            double r = (stages.length-idx)==0?0:(idx2-idx)/(stages.length-idx*1.0);
            if(!rate.contains(r)) rate.add(r);
            if(!hm.containsKey(r)) hm.put(r, new ArrayList<Integer>());
            hm.get(r).add(i);
            idx = idx2;
        }
        Collections.sort(rate,Collections.reverseOrder());
        //Collections.sort(rate);
        int[] ret = new int[N];
        idx = 0;
        for(Double r : rate) {
            List<Integer> list = hm.get(r);
            for(int l : list) ret[idx++] = l;
        }
        return ret;
    }
}
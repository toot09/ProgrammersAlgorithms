import java.util.*;
class REDO_하노이의_탑 {
    private List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        helper(1, 2, 3, n);
        int[][] ret = new int[list.size()][2];
        for(int i=0 ; i<list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public void helper(int s, int via, int e, int n) {
        if(n==1) {
            list.add(new int[]{s, e});
            return;
        }
        helper(s, e, via, n-1);
        list.add(new int[]{s, e});
        helper(via, s, e, n-1);
        
        return;
    }
}
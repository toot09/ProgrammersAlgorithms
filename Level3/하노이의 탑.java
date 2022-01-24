import java.util.*;
class 하노이의_탑 {
    List<List<Integer>> move;
    public int[][] solution(int n) {
        move = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        int[][] ret = new int[move.size()][2];
        for(int i=0 ; i<move.size() ; i++) {
            ret[i][0] = move.get(i).get(0);
            ret[i][1] = move.get(i).get(1);
        }
        return ret;
    }
    public void hanoi(int n, int start, int via, int end) {
        if(n==1) {
            move(start, end);
        } else {
            hanoi(n-1, start, end, via);
            move(start, end);
            hanoi(n-1, via, start, end);
        }
        return;
    }
    public void move(int start, int end) {
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        move.add(list);
        return;
    }
}
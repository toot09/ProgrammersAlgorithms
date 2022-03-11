import java.util.*;
class 나머지한점찾기 {
    public int[] solution(int[][] v) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for(int[] p : v) {
            insertPoint(p[0], x);
            insertPoint(p[1], y);
        }

        return new int[]{x.get(0), y.get(0)};
    }

    public void insertPoint(int p, List<Integer> list) {
        if(list.contains(p)) list.remove(Integer.valueOf(p));
        else list.add(p);
    }

}
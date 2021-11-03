import java.util.*;
class 빛의경로사이클 {
    public int[] solution(String[] grid) {
        int m=grid.length, n=grid[0].length();
        
        String[][] map = new String[m][n];
        for(int i=0 ; i<m ; i++) {
            map[i] = grid[i].split("");
        }

        boolean[][][] visit = new boolean[m][n][4];
        
        // U:0, D:1, L:2, R:3
        Map<String, int[][]> dir = new HashMap<>();
        // cur, point by before
        dir.put("S", new int[][]{{-1,0},{1,0},{0,-1},{0,1}});
        dir.put("R", new int[][]{{0,1},{0,-1},{-1,0},{1,0}});
        dir.put("L", new int[][]{{0,-1},{0,1},{1,0},{-1,0}});

        List<Integer> list = new ArrayList<>();

        Map<String, int[]> next = new HashMap<>();
        // curr, next step array
        next.put("S", new int[]{0,1,2,3});
        next.put("R", new int[]{3,2,0,1});
        next.put("L", new int[]{2,3,1,0});

        for(int i=0 ; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                int stepI=i, stepJ=j;
                // U:0, D:1, L:2, R:3
                for(int k=0 ; k<4 ; k++) {
                    int cnt = 0, d=k;
                    while(!visit[stepI][stepJ][d]) {
                        visit[stepI][stepJ][d] = true;
                        cnt++;
                        int nxt = next.get(map[stepI][stepJ])[d];
                        int[] s = dir.get(map[stepI][stepJ])[d];
                        stepI = (stepI+s[0]+m)%m;
                        stepJ = (stepJ+s[1]+n)%n;
                        d = nxt;
                    }
                    if(cnt>0) list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        int[] ret = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
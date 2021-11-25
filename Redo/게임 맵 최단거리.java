import java.util.*;
class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int[][] move = new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int m=maps.length, n=maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        maps[0][0] = 0;
        while(!q.isEmpty()) {
            int[] coo = q.poll();
            int r = coo[0], l = coo[1];
            for(int i=0 ; i<move.length ; i++) {
                int rMV=r+move[i][0], lMV=l+move[i][1];
                if(rMV==m-1 && lMV==n-1) {
                    return coo[2]+(i==0?0:1);
                }
                if(i==0) continue;
                if(check(maps, rMV, lMV)) {
                    maps[rMV][lMV] = 0;
                    q.offer(new int[]{rMV, lMV, coo[2]+1});
                }
            }
        }
        return -1;
    }

    public boolean check(int[][] maps, int r, int l) {
        return r>=0 && r<maps.length && l>=0 && l<maps[0].length && maps[r][l]==1;
    }
}
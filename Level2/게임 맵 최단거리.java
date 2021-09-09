import java.util.*;
class gamemapshortest {
    public int solution(int[][] maps) {
        int m=maps.length, n=maps[0].length, cnt=1;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()) {
            int len = q.size();
            for(int l=1 ; l<=len ; l++) {
                int[] p = q.poll();
                int i=p[0], j=p[1];
                if(i==m-1 && j==n-1) return cnt;
                if(i<0 || i>=maps.length || j<0 || j>=maps[0].length || maps[i][j]==0 || visit[i][j]) continue;
                visit[i][j] = true;
                q.offer(new int[]{i-1, j});
                q.offer(new int[]{i, j-1});
                q.offer(new int[]{i+1, j});
                q.offer(new int[]{i, j+1});
            }
            cnt++;
        }
        return -1;
    }
}
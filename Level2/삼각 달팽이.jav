import java.util.*;
class Solution {
    public int[] solution(int n) {
        int dir = 0;
        int i=0 , j=0;
        int max = (1+n)*n/2;
        int[][] arr = new int[n][n];
        boolean[][] visit= new boolean[n][n];
        for(int num=1 ; num<=max ; num++) {
            arr[i][j] = num;
            visit[i][j] = true;
            if(dir%3==0) {
                if((i+1)>=n || visit[i+1][j]){
                    dir++;
                    j++;
                } else {
                    i++;
                }
            } else if(dir%3==1) {
                if((j+1)>=n || visit[i][j+1]){
                    dir++;
                    j--;
                    i--;
                } else {
                    j++;
                }
            } else {
                if(visit[i-1][j-1]){
                    dir++;
                    i++;
                } else {
                    i--;
                    j--;
                }
            }
        }

        int idx = 0;
        int[] ret = new int[max];
        for(int ii=0 ; ii<n ; ii++) {
            for(int jj=0 ; jj<n ; jj++) {
                if(arr[ii][jj]==0) break;
                ret[idx++] = arr[ii][jj];
            }
        }
        return ret;
    }
}
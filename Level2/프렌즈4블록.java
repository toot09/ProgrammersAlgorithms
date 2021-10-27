import java.util.*;
class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        String[][] map = new String[m][n];
        
        for(int i=0 ; i<m ; i++) {
            map[i] = board[i].split("");
        }

        int countX = 0;
        while(true) {
            String[][] next = new String[m][n];
            // 임시 Array 만들기
            for(int i=0 ; i<m ; i++) {
                next[i] = Arrays.copyOf(map[i], n);
            }
            Set<String> hs = new HashSet<>();
            // 사각형 터뜨리기
            for(int i=0 ; i<m-1 ; i++) {
                for(int j=0 ; j<n-1 ; j++) {
                    helper(i, j, next, map, hs);
                }
            }
            // 터뜨린 케이스가 없다면 break;
            if(hs.isEmpty()) {
                break;
            }
            countX += hs.size();
            // X올리기
            for(int j=0 ; j<n ; j++) {
                swapper(j, next);
            }
            map = next;
        }
        return countX;
    }

    public void swapper(int j, String[][] map) {
        int ic = map.length-1, ix = map.length-1;
        while(ic>=0 && ix>=0) {
            while(ic>=0 && map[ic][j].equals("X")) {
                ic--;
            }
            while(ix>ic && ix>=0 && !map[ix][j].equals("X")) {
                ix--;
            }
            if(ic>=0 && ix>ic) {
                map[ix][j] = map[ic][j];
                map[ic][j] = "X";
            }
            ix--;
            ic--;
        }
    }

    public void helper(int i, int j, String[][] next, String[][] map, Set<String> hs) {
        //System.out.println("i : "+i+" / j : "+j);
        if(map[i][j].equals("X") || map[i+1][j].equals("X") || map[i][j+1].equals("X") || map[i+1][j+1].equals("X")) return;
        if(map[i][j].equals(map[i+1][j]) && map[i][j].equals(map[i][j+1]) && map[i][j].equals(map[i+1][j+1])) {
            next[i][j] = "X";
            next[i+1][j] = "X";
            next[i][j+1] = "X";
            next[i+1][j+1] = "X";
            hs.add(i+"|"+j);
            hs.add((i+1)+"|"+j);
            hs.add(i+"|"+(j+1));
            hs.add((i+1)+"|"+(j+1));
        }
        return;
    }
}
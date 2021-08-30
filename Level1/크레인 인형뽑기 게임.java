// Difficulty : 1
// Comment : Easy but have to set definitely correct blueprint
// url : https://programmers.co.kr/learn/courses/30/lessons/64061?language=java


import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] rows = new int[board[0].length];
        for(int i=0 ; i<board[0].length ; i++) {
            int idx=0;
            while(idx<board.length && board[idx][i]==0) idx++;
            rows[i] = idx;
            //System.out.println(rows[i]);
        }
        Stack<Integer> s = new Stack<>();
        for(int move : moves) {
            move -= 1;
            if(rows[move]>=board.length) continue;
            int num = board[rows[move]++][move];
            if(helper(s, num)) answer+=2;
        }
        return answer;
    }
    public boolean helper(Stack<Integer> s, int num) {
        if(!s.isEmpty() && s.peek()==num) {
            s.pop();
            return true;
        }
        s.push(num);
        return false;
    }
}
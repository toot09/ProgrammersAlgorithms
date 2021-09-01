// Difficulty : 2
// Comment : Easy
// url : https://programmers.co.kr/learn/courses/30/lessons/42626?language=java


import java.util.*; 
//섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
class themg {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return a-b;
        });
        int answer = 0;
        for(int sc : scoville) pq.offer(sc);
        while(pq.peek()<K && pq.size()>1) {
            int sc1 = pq.poll(), sc2 = pq.poll();
            pq.offer(sc1+(2*sc2));
            answer++;
        }
        return pq.peek()<K?-1:answer;
    }
}
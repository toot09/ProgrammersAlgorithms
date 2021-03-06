// Difficulty : 1
// Comment : Easy
// url : https://programmers.co.kr/learn/courses/30/lessons/76501?language=java


class pn {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0 ; i<signs.length ; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
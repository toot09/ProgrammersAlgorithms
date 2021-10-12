class 평균구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        for(int n : arr) answer+=n;
        return answer/arr.length;
    }
}
class 두정수사이의합 {
    public long solution(int a, int b) {
        if(a>b) return solution(b, a);
        return ((long)(b+a)*(long)(b-a+1)/2);
    }
}
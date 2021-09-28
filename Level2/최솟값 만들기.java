import java.util.*;
class csgmdg {
    public int solution(int[] A, int[] B) {
        int answer = 0, len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0 ; i<len ; i++) {
            answer += (A[i]*B[len-i-1]);
        }
        return answer;
    }
}
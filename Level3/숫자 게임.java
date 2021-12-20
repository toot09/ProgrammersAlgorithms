import java.util.*;
class 숫자_게임 {
    public int solution(int[] A, int[] B) {
        int s=0, e=A.length-1, win=0, idx=A.length-1;
		Arrays.sort(A);
		Arrays.sort(B);
		while(idx>=0) {
			if(A[idx]>=B[e]) {
				s++;
			} else {
				win++;
				e--;
			}
			idx--;
		}
		return win;
    }
}
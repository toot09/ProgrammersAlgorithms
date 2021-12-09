import java.util.*;
class N으로표현 {
    private int ret = 9;
    private List<List<Integer>> nums;
    public int solution(int N, int number) {
		nums = new ArrayList<>();
		// 0개는 그냥 보기 쉽도록 빈 list 넣어준다.
		nums.add(new ArrayList<Integer>());
		StringBuilder sb = new StringBuilder();
		for(int i=1 ; i<=8 ; i++) {
			nums.add(new ArrayList<Integer>());
			sb.append(""+N);
			int insert = Integer.valueOf(sb.toString());
			if(insert==number) {
				return i;
			} else {
				nums.get(i).add(insert);
			}
		}
		for(int i=1 ; i<=7 ; i++) {
			List<Integer> l1 = nums.get(i);
			for(int j=1 ; i+j<=8 ; j++) {
				List<Integer> l2 = nums.get(j);
				helper(i,j);
                if(nums.get(i+j).contains(number) && ret>i+j) ret = i+j;
			}
		}
		return ret>8?-1:ret;
    }
    
    public void helper(int i, int j) {
        List<Integer> l1 = nums.get(i);
        List<Integer> l2 = nums.get(j);
        
        for(int n1=0 ; n1<l1.size(); n1++) {
            for(int n2=0 ; n2<l2.size(); n2++) {
                int plus = l1.get(n1)+l2.get(n2);
                int mul = l1.get(n1)*l2.get(n2);
                int minus = Math.max(l1.get(n1),l2.get(n2))-Math.min(l1.get(n1),l2.get(n2));
                int div = Math.max(l1.get(n1),l2.get(n2))/Math.min(l1.get(n1),l2.get(n2));
                if(!nums.get(i+j).contains(plus)) 				nums.get(i+j).add(plus);
                if(!nums.get(i+j).contains(mul)) 				nums.get(i+j).add(mul);
                if(!nums.get(i+j).contains(minus)&& minus>0) 	nums.get(i+j).add(minus);
                if(!nums.get(i+j).contains(div)&& div>0) 		nums.get(i+j).add(div);
            }
        }
        return;
    }
    
}
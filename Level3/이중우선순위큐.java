import java.util.*;
class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        List<Integer> nums = new ArrayList<>();
		int idx=0;
		while(idx<operations.length) {
			while(idx<operations.length && operations[idx].charAt(0)=='D') {
				if(nums.size()>0) {
					if(operations[idx].split(" ")[1].length()>1) {
						// -1
						nums.remove(0);
					} else {
						// 1
						nums.remove(nums.size()-1);
					}
				}
				idx++;
			}
			while(idx<operations.length && operations[idx].charAt(0)=='I') {
				nums.add(Integer.valueOf( operations[idx++].split(" ")[1] ));
			}
			Collections.sort(nums);
		}
		return nums.size()==0?new int[]{0,0}:new int[]{nums.get(nums.size()-1), nums.get(0)};
    }
}
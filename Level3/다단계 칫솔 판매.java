import java.util.*;
class 다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> score = new HashMap<>();
        Map<String, String> pre = new HashMap<>();
        for(int i=0 ; i<enroll.length ; i++) {
        	score.put(enroll[i], 0);
        	pre.put(enroll[i], referral[i]);
        }
        for(int i=0 ; i<seller.length ; i++) {
        	int amt = amount[i]*100;
        	String sell = seller[i];
        	while(pre.containsKey(sell) && amt>0) {
        		int profit = (int)(amt*0.1);
        		score.put(sell, score.get(sell)+(amt-profit));
        		amt = profit;
        		sell = pre.get(sell);
        	}
        }
        int[] ret = new int[enroll.length];
        for(int i=0 ; i<ret.length ; i++) {
        	ret[i] = score.get(enroll[i]);
        }
        return ret;
    }
}
import java.util.*;
class 수식최대화 {
    private long maxNum = 0;
    public long solution(String exp) {
        String[] seq = new String[]{"*","+","-"};
        boolean[] visit = new boolean[3];
        List<String> nums = new ArrayList<>();
        List<String> signs = new ArrayList<>();
        int idx=0, s=0;
        while(idx<exp.length()) {
            char c = exp.charAt(idx);
            if(!Character.isDigit(c)) {
                nums.add(exp.substring(s, idx));
                signs.add(""+c);
                s = idx+1;
            }
            if(idx==exp.length()-1) {
                nums.add(exp.substring(s, exp.length()));
            }
            idx++;
        }
        helper(nums, signs, seq, visit, 0);
        return maxNum;
    }
    
    public void helper(List<String> nums, List<String> signs, String[] seq, boolean[] visit, int cnt) {
        if(cnt==3) {
            maxNum = Math.max(maxNum, Math.abs(Long.valueOf(nums.get(0))));
            return;
        }
        for(int i=0 ; i<3 ; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            String s = seq[i];
            
            List<String> num = getClone(nums);
            List<String> sign = getClone(signs);

            while(sign.indexOf(s)!=-1) {
                int signIdx = sign.indexOf(s);
                long num1 = Long.valueOf(num.get(signIdx)), num2 = Long.valueOf(num.get(signIdx+1));
                num.set(signIdx, cal(num1, num2, s));
                num.remove(signIdx+1);
                sign.remove(signIdx);
            }
            helper(num, sign, seq, visit, cnt+1);
            visit[i] = false;
        }
        return;
    }
    
    public String cal(long num1, long num2, String sign) {
        long ret;
        if(sign.equals("+")) {
            ret = num1+num2;
        } else if(sign.equals("-")) {
            ret = num1-num2;
        } else {
            ret = num1*num2;
        }
        return String.valueOf(ret);
    }
    
    public List<String> getClone(List<String> org) {
        List<String> ret = new ArrayList<>();
        for(String o : org) {
            ret.add(o);
        }
        return ret;
    }
    
}
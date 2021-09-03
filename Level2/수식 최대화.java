import java.util.*;
class ssch {
    private String[] sign = new String[]{"*","+","-"};
    private boolean[] visit = new boolean[3];
    private long ret = 0;
    
    public long solution(String expression) {
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0 ; i<expression.length() ; i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            } else {
                list.add(sb.toString());
                list.add(""+c);
                sb.setLength(0);
            }
        }
        list.add(sb.toString());
        //"100-200*300-500+20"
        //"100","-","200","*","300","-","500","+","20";
        
        //for(int i=1 ; i<3; i++) {
        helper(list, visit);
        //}
        
        return ret;
    }
    public void helper(List<String> list, boolean[] visit) {
        if(list.size()==1) {
            long calNum = Long.valueOf(list.get(0));
            // System.out.println("list.get(0) : "+list.get(0));
            // System.out.println("Integer.valueOf(list.get(0) : "+Integer.valueOf(list.get(0)));
            // System.out.println("Long.valueOf(list.get(0) : "+Long.valueOf(list.get(0)));
            if(calNum<0) calNum*=-1;
            if(ret<calNum) ret = calNum;
            return;
        }
        
        //for(String numm : list) System.out.print(numm+" ");
        //System.out.println();
            
        for(int i=0 ; i<3 ; i++) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(list);
            if(visit[i]) continue;
            visit[i] = true;
            String c = sign[i];
            while(tmp.indexOf(c)>=0){
                int idx = tmp.indexOf(c);
                long num1 = Long.valueOf(tmp.get(idx-1));
                long num2 = Long.valueOf(tmp.get(idx+1));
                for(int d=3; d>0 ; d--) tmp.remove(idx-1);
                tmp.add(idx-1, String.valueOf(cal(num1, num2, c)));
            }
            helper(tmp, visit);
            visit[i] = false;
        }
    }
    
    public long cal(long num1, long num2, String c) {
        if(c.equals("+")) {
            return num1+num2;
        } else if(c.equals("-")) {
            return num1-num2;
        } else {
            return num1*num2;
        }
    }
}

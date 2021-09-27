import java.util.*;
class ac {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        for(int i=0 ; i<msg.length() ; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            while(i+1<msg.length() && dict.contains(sb.toString()+msg.charAt(i+1))) {
                i++;
                sb.append(msg.charAt(i));
            }
            if(sb.length()==1) list.add(msg.charAt(i)-'A'+1);
            else list.add(dict.indexOf(sb.toString())+27);
            if(i<msg.length()-1) dict.add(sb.toString()+msg.charAt(i+1));
        }
        int[] ret = new int[list.size()];
        for(int i=0; i<ret.length ; i++) ret[i] = list.get(i);
        return ret;
        }
}
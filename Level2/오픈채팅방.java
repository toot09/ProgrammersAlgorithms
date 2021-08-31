// Difficulty : 2
// Comment : Easy
// url : https://programmers.co.kr/learn/courses/30/lessons/42888?language=java


import java.util.*;
class openChatting {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        Map<String, String> hm = new HashMap<>();
        for(String rc : record) {
            //"Enter uid1234 Muzi"
            String[] conv = rc.split(" ");
            if(conv[0].equals("Enter")) {
                hm.put(conv[1], conv[2]);
                list.add(new String[]{conv[1], "님이 들어왔습니다."});
            } else if(conv[0].equals("Leave")) {
                list.add(new String[]{conv[1], "님이 나갔습니다."});
            } else {
                hm.put(conv[1], conv[2]);
            }
        }
        String[] ret = new String[list.size()];
        for(int i=0 ; i<ret.length ; i++) {
            ret[i] = hm.get(list.get(i)[0])+list.get(i)[1];
        }
        return ret;
    }
}
import java.util.*;
class phonebook {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0 ; i<phone_book.length-1 ; i++) {
            if(phone_book[i].indexOf(phone_book[i+1])==0 || phone_book[i+1].indexOf(phone_book[i])==0) return false;
        }
        return true;
    }
}
/*
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> hs = new HashSet<>();
        Arrays.sort(phone_book,(a,b)->{
           return b.length()-a.length(); 
        });
        for(String p : phone_book) {
            if(hs.contains(p)) return false;
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<p.length() ; i++) {
                sb.append(p.charAt(i));
                hs.add(sb.toString());
            }
        }
        return true;
    }
}
*/
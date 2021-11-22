import java.util.*;
class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        List<String> list = new ArrayList<>();
        int inter = 0, len1=0, len2=0;
        for(int i=0 ; i<str1.length()-1 ; i++) {
            char c1 = Character.toUpperCase(str1.charAt(i)), c2 = Character.toUpperCase(str1.charAt(i+1));
            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }
            list.add(""+c1+c2);
            len1++;
        }
        for(int i=0 ; i<str2.length()-1 ; i++) {
            char c1 = Character.toUpperCase(str2.charAt(i)), c2 = Character.toUpperCase(str2.charAt(i+1));
            if(!Character.isAlphabetic(c1) || !Character.isAlphabetic(c2)) {
                continue;
            }
            int idx = list.indexOf(""+c1+c2);
            if(idx != -1) {
                inter++;
                list.remove(idx);
            }
            len2++;
        }
        return (len1+len2-inter)==0?65536:65536*inter/(len1+len2-inter);
    }
}
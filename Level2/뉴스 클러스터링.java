import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();
        getString(str1, list1);
        getString(str2, list2);
        for(String s1 : list1) {
            if(list2.remove(s1)) {
                intersection.add(s1);
            }
            union.add(s1);
        }
        for(String s2 : list2) {
            union.add(s2);
        }
        
        double jakard = 1;
        if(union.size()>0) {
            jakard = (double)intersection.size() / (double)union.size();
        }
        return (int)(65536*jakard);
        
    }
    public void getString(String s, List<String> list) {
        for(int i=0; i<s.length()-1 ; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                //System.out.println(""+c1+c2);
                list.add(String.valueOf(""+c1+c2).toLowerCase());
            }
        }
    }
}
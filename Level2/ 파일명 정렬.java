import java.util.*;
class 파일정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (s1,s2)->{
            String head1 = s1.split("[0-9]")[0].toLowerCase();
            String head2 = s2.split("[0-9]")[0].toLowerCase();
            if(!head1.equals(head2)) {
                return head1.compareTo(head2);
            }
            return getNum5(s1, head1.length())-getNum5(s2, head2.length());
        });
        return files;
    }

    public int getNum5(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        while(idx<s.length() && sb.length()<5 && Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }
        return Integer.valueOf(sb.toString());
    }
}
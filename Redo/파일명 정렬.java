import java.util.*;
class 파일명정렬 {
    public String[] solution(String[] files) {
        String[][] data = new String[files.length][4];
        for(int i=0 ; i<files.length ; i++) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            String file = files[i];
            int idx = 0;
            while(!Character.isDigit(file.charAt(idx))) {
                head.append(Character.toLowerCase(file.charAt(idx++)));
            }
            int idx2=idx;
            while(idx<file.length() && idx-idx2<5  && Character.isDigit(file.charAt(idx))) {
                number.append(file.charAt(idx++));
            }
            data[i][0] = head.toString();
            data[i][1] = number.toString();
            data[i][2] = ""+i;
            data[i][3] = file;
        }

        Arrays.sort(data, (a,b)->{
            if(!a[0].equals(b[0])) {
                return a[0].compareTo(b[0]);
            } else if(!a[1].equals(b[1])) {
                return Integer.valueOf(a[1])-Integer.valueOf(b[1]);
            }
            return Integer.valueOf(a[2])-Integer.valueOf(b[2]);
        });
        String[] ret = new String[files.length];
        int idx = 0;
        for(String[] d : data) {
            ret[idx++] = d[3];
        }
        return ret;
    }
}
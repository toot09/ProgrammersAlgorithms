import java.util.*;
class 교점에별만들기 {
    private int rMax = Integer.MIN_VALUE;
    private int cMax = Integer.MIN_VALUE;
    private int rMin = Integer.MAX_VALUE;
    private int cMin = Integer.MAX_VALUE;
    private Set<String> hs = new HashSet<>();
    public String[] solution(int[][] line) {
        for(int i=0 ; i<line.length-1 ; i++) {
            for(int j=i+1 ; j<line.length ; j++) {
                helper(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
            }
        }
        String[] ret = new String[rMax-rMin+1];
        for(int i=rMax ; i>=rMin ; i--) {
            StringBuilder sb = new StringBuilder();
            for(int j=cMin ; j<=cMax ; j++) {
                sb.append(hs.contains(i+"|"+j)?"*":".");
            }
            ret[rMax-i] = sb.toString();
        }
        return ret;
    }
    
    public void helper(int xx1, int yy1, int zz1, int xx2, int yy2, int zz2) {
        
        long x1=(long)xx1, y1=(long)yy1, z1=(long)zz1;
        long x2=(long)xx2, y2=(long)yy2, z2=(long)zz2;
        if(x1*y2==y1*x2 || (y1*z2-y2*z1)%(x1*y2-y1*x2)!=0 || (x2*z1-x1*z2)%(x1*y2-y1*x2)!=0) {
            return;
        }
        int x = (int)(y1*z2-y2*z1)/(int)(x1*y2-y1*x2);
        int y = (int)(x2*z1-x1*z2)/(int)(x1*y2-y1*x2);
        hs.add(y+"|"+x);
        rMax = Math.max(rMax, y);
        rMin = Math.min(rMin, y);
        cMax = Math.max(cMax, x);
        cMin = Math.min(cMin, x);
    }
}
import java.util.*;
class 복서정렬하기 {
    public int[] solution(int[] weights, String[] head2head) {
        int[] rate = new int[weights.length];
        int[] win = new int[weights.length];
        for(int i=0 ; i<weights.length ; i++) {
            String head = head2head[i];
            int tot=0, w=0, ww=0;
            for(int j=0 ; j<head.length() ; j++) {
                char c = head.charAt(j);
                if(c=='N') continue;
                tot++;
                if(c=='W') {
                    w++;
                    if(weights[i]<weights[j]) ww++;
                }
            }
            rate[i] = (tot==0?0:(int)(w/(tot*1.0)*100000000));
            win[i] = ww;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(rate[a]!=rate[b]) {
                return rate[b]-rate[a];
            } else if(win[a]!=win[b]) {
                return win[b]-win[a];
            } else if(weights[a]!=weights[b]) {
                return weights[b]-weights[a];
            } else {
                return a-b;
            }
        });
        for(int i=0 ; i<weights.length ; i++) {
            pq.offer(i);
        }
        int[] ret = new int[weights.length];
        for(int i=0 ; i<ret.length ; i++) {
            ret[i] = pq.poll()+1;
        }
        return ret;
    }
}
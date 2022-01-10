import java.util.*;
class 표_편집 {
    private boolean sort;
	private PriorityQueue<Integer> pq;
	private List<Integer> pre;
	private Stack<Integer> del;
    public String solution(int n, int k, String[] cmd) {
        pq = new PriorityQueue<>((a,b)-> {
			return a-b;
		});
		pre = new ArrayList<>();
		del = new Stack<>();
		sort = true;
		char[] ret = new char[n];
		
		init(pq, pre, n, k);
		
		for(String command : cmd) {
			String[] c = command.split(" ");
			operation(c[0], c.length==1?0:Integer.valueOf(c[1]));
		}
		
		if(pre.size()+pq.size()<del.size()) {
			Arrays.fill(ret, 'X');
			for(int i=0 ; i<pre.size() ; i++) {
				ret[pre.get(i)] = 'O';
			}
			while(!pq.isEmpty()) {
				ret[pq.poll()] = 'O';
			}
		} else {
			Arrays.fill(ret, 'O');
			while(!del.isEmpty()) {
				ret[del.pop()] = 'X';
			}
		}
		return String.valueOf(ret);
    }
    
    public void operation(String cmd, int num) {
		if(cmd.equals("D")) {
			for(int i=1 ; i<=num ; i++) {
				pre.add(pq.poll());
			}			
		} else if(cmd.equals("U")) {
			
			moveToPQ(Integer.valueOf(num));
			
		} else if(cmd.equals("C")) {
			del.add(pq.poll());
			if(pq.isEmpty()) {
				moveToPQ(Integer.valueOf(1));
			}
		} else {
			int tmp = del.pop();
			if(pq.peek()<tmp) {
				pq.offer(tmp);
			} else {
				pre.add(tmp);
				sort = false;
			}
		}
	}
	
	public void moveToPQ(int n) {
		if(!sort) {
			Collections.sort(pre);
			sort = true;
		}
		for(int i=1 ; i<=n ; i++) {
			pq.add(pre.get(pre.size()-1));
			pre.remove(pre.size()-1);
		}
		return;
	}
	
	public void init(PriorityQueue<Integer> pq, List<Integer> pre, int n, int k) {
		int idx=0;
		while(idx<k) {
			pre.add(idx);
			idx++;
		}
		while(idx<n) {
			pq.offer(idx);
			idx++;
		}
		return;
	}
    
}
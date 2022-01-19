class 양궁대회 {
    private int[] MaxRet;
	private int MaxScore;
    public int[] solution(int n, int[] info) {
        MaxRet = new int[11];
		MaxScore = 0;class Solution {
    private int[] MaxRet;
	private int MaxScore;
    public int[] solution(int n, int[] info) {
        MaxRet = new int[11];
		MaxScore = 0;
		helper(info, n, 0, 0, 0, new int[11]);
		return MaxScore==0?new int[]{-1}:MaxRet;
    }
    public void helper(int[] info, int n, int score, int opponent, int idx, int[] arr) {
		if(idx==10) {
			if(score-opponent>=MaxScore) {
				arr[idx] = n;
				if(MaxScore<(score-opponent)) {
					// set
					setArr(arr);
					MaxScore = score-opponent;
					
				} else if(MaxScore==(score-opponent)) {
					// sort check -> set
					if(checkSort(arr)) setArr(arr);
				}
			}
			return;
		}
		// 이길떄
		if(info[idx]<n) {
			arr[idx] = info[idx]+1;
			helper(info, n-(info[idx]+1), score+(10-idx), opponent, idx+1, arr);
		}
        // 질때
        arr[idx] = 0;
		helper(info, n, score, opponent+(info[idx]>0?(10-idx):0), idx+1, arr);
		return;
	}
	
	public void setArr(int[] arr) {
		for(int i=0 ; i<=10 ; i++) {
			MaxRet[i] = arr[i];
		}
		return;
	}
	
	public boolean checkSort(int[] arr) {
		for(int i=10 ; i>=0 ; i--) {
			if(MaxRet[i]==arr[i]) {
				continue;
			} else if(MaxRet[i]<arr[i]) {
				return true;
			} else {
				break;
			}
		}
		return false;
	}
    
}
		helper(info, n, 0, 0, 0, new int[11]);
		return MaxScore==0?new int[]{-1}:MaxRet;
    }
    public void helper(int[] info, int n, int score, int opponent, int idx, int[] arr) {
		if(idx==10) {
			if(score-opponent>=MaxScore) {
				arr[idx] = n;
				if(MaxScore<(score-opponent)) {
					// set
					setArr(arr);
					MaxScore = score-opponent;
					
				} else if(MaxScore==(score-opponent)) {
					// sort check -> set
					if(checkSort(arr)) setArr(arr);
				}
			}
			return;
		}
		// 이길떄
		if(info[idx]<n) {
			arr[idx] = info[idx]+1;
			helper(info, n-(info[idx]+1), score+(10-idx), opponent, idx+1, arr);
		}
        // 질때
        arr[idx] = 0;
		helper(info, n, score, opponent+(info[idx]>0?(10-idx):0), idx+1, arr);
		return;
	}
	
	public void setArr(int[] arr) {
		for(int i=0 ; i<=10 ; i++) {
			MaxRet[i] = arr[i];
		}
		return;
	}
	
	public boolean checkSort(int[] arr) {
		for(int i=10 ; i>=0 ; i--) {
			if(MaxRet[i]==arr[i]) {
				continue;
			} else if(MaxRet[i]<arr[i]) {
				return true;
			} else {
				break;
			}
		}
		return false;
	}
    
}
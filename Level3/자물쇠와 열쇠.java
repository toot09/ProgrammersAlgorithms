class 좌물쇠와_열쇠 {
    private static int i1, j1, i2, j2, r, c;
    public boolean solution(int[][] key, int[][] lock) {
        int lockLen=lock.length, keyLen=key.length, hole=0;
        i1=Integer.MAX_VALUE;
        j1=Integer.MAX_VALUE;
        i2=Integer.MIN_VALUE;
        j2=Integer.MIN_VALUE;
        int[][][] keys = new int[4][keyLen][keyLen];
        
        for(int i=0 ; i<lockLen ; i++) {
        	for(int j=0 ; j<lockLen ; j++) {
        		if(lock[i][j]==0) {
        			i1 = Math.min(i1, i);
        			i2 = Math.max(i2, i);
        			j1 = Math.min(j1, j);
        			j2 = Math.max(j2, j);
        			hole++;
        		}
        	}
        }
        if(hole==0) return true;
        r = i2-i1+1;
        c = j2-j1+1;
        for(int i=0 ; i<keyLen ; i++) {
        	for(int j=0; j<keyLen ; j++) {
        		keys[0][i][j] = key[i][j];
        	}
        }
        keyRotation(keys, keyLen);
        for(int i=0 ; i+r-1<keyLen ; i++) {
			for(int j=0 ; j+c-1<keyLen ; j++) {
                if(dfsLockKey(lock, keys, keyLen, i, j)) return true;
            }
        }
        return false;
    }
    public boolean dfsLockKey(int[][] lock, int[][][] keys, int keyLen, int i, int j) {
        for(int k=0 ; k<4 ; k++) {
            int cnt = 0;
            for(int x=0 ; x<r ; x++) {
                for(int y=0 ; y<c ; y++) {
                    if(keys[k][i+x][j+y]!=lock[i1+x][j1+y]) {
                        cnt++;
                    }
                }
            }
            if(cnt==r*c) return true;
		}
		return false;
	}
	public void keyRotation(int[][][] keys, int keyLen) {
		for(int k=1 ; k<4 ; k++) {
			for(int i=0 ; i<keyLen ; i++) {
				for(int j=0 ; j<keyLen ; j++) {
					keys[k][i][j] = keys[k-1][j][keyLen-i-1];
				}
			}
		}
		return;
	}
}
import java.util.*;
class 기둥과_보_설치 {
    private boolean[][] pillar;
	private boolean[][] floor;
    public int[][] solution(int n, int[][] build_frame) {
        int structure = 0;
		pillar = new boolean[n+1][n+1];
		floor = new boolean[n+1][n+1];
		
		for(int[] bf : build_frame) {
			int x=bf[0], y=bf[1], type=bf[2], action=bf[3];
			if(action==0) {
			// 삭제
				if(type==0) { // 기둥
					pillar[x][y] = false;
					if(checkAll(n)) {
						structure--;
					} else {
						pillar[x][y] = true;
					}
				} else { // 보
					floor[x][y] = false;
					if(checkAll(n)) {
						structure--;
					} else {
						floor[x][y] = true;
					}
				}
			} else {
			// 설치
				if(type==0) { // 기둥
					if(checkPillar(x, y, n)) {
						pillar[x][y] = true;
						structure++;
					}
				} else { // 보
					if(checkFloor(x, y, n)) {
						floor[x][y] = true;
						structure++;
					}
				}
			}
						
		}
		int[][] ret = new int[structure][3];
		int idx=0;
		for(int x=0 ; x<=n && idx<structure ; x++) {
			for(int y=0 ; y<=n && idx<structure ; y++) {
				if(pillar[x][y]) {
					ret[idx][0] = x;
					ret[idx][1] = y;
					ret[idx][2] = 0;
					idx++;
				}
				if(floor[x][y]) {
					ret[idx][0] = x;
					ret[idx][1] = y;
					ret[idx][2] = 1;
					idx++;
				}
			}
		}
		return ret;
    }
    public boolean checkAll(int n) {
		for(int x=0 ; x<=n ; x++) {
			for(int y=0 ; y<=n ; y++) {
				if(pillar[x][y]) {
					if(!checkPillar(x, y, n)) return false;
				}
				if(floor[x][y]) {
					if(!checkFloor(x, y, n)) return false;
				}
			}
		}
		return true;
	}
	
	//	기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
	public boolean checkPillar(int x, int y, int n) {
		// 바닥
		if(y==0) return true;
		// 기둥위
		if(pillar[x][y-1]) return true;
		// 보의 끝부분 위치
		if((x-1>=0 && floor[x-1][y]) || floor[x][y]) return true;
		
		return false;
	}
	
	//	보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
	public boolean checkFloor(int x, int y, int n) {
		// 기둥의 끝부분 위치
		if(x+1<=n && pillar[x+1][y-1]) return true;
		// 기둥의 시작부분 위치
		if(pillar[x][y-1]) return true;
		// 양 옆 보 위치
		if(x-1>=0 && x+1<=n && floor[x-1][y] && floor[x+1][y]) return true;
		
		return false;
	}
}
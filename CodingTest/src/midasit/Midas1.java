package midasit;

public class Midas1 {
	int[][] map;
	int[][] pos = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}}; // 상,좌상,좌,좌하,하,하우,우,우상
	public static void main(String[] args) {
		Midas1 m = new Midas1();
		int[][] mine = {{1, 1}, {1, 7}, {2, 7}, {3, 6}, {4, 1}, {4, 4}, {4, 8}, {8, 4}, {8, 5}, {9, 6}};
		m.solution(9, mine);
	}
	
	public int[][] solution(int N, int[][] mine) {
		map = new int[N+1][N+1];
		
        int[][] answer = {};
        
        for (int[] mineArr : mine) map[mineArr[0]][mineArr[1]] = -1;
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=N; j++) {
        		if(map[i][j] != -1) {
        			int mineNum = checkMine(N, i, j);
        			map[i][j] = mineNum;
        		}
        	}
        }

        answer = printMap(N);
        return answer;
    }

	public int[][] printMap(int N) {
		int[][] answer = new int[N][N];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				answer[i-1][j-1] = map[i][j];
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		return answer;
	}
	
	public int checkMine(int N, int r, int c) {
		int count = 0;
		for (int i = 0; i < pos.length; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(isRange(N, nr, nc) && map[nr][nc] == -1) {
				count++;
			}
		}
		
		return count;
	}
	
	public boolean isRange(int N, int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
	
}

/*

[[-1, 1, 0, 0, 0, 2,-1, 2, 0],
[ 1, 1, 0, 0, 1, 3,-1, 2, 0],
[ 1, 1, 1, 1, 2,-1, 3, 2, 1],
[-1, 1, 1,-1, 2, 1, 2,-1, 1],
[ 1, 1, 1, 1, 1, 0, 1, 1, 1],
[ 0, 0, 0, 0, 0, 0, 0, 0, 0],
[ 0, 0, 1, 2, 2, 1, 0, 0, 0],
[ 0, 0, 1,-1,-1, 2, 1, 0, 0],
[ 0, 0, 1, 2, 3,-1, 1, 0, 0]]


*/
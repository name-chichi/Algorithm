package study01;

import java.util.Scanner;

public class BOJ_1012 {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		// 테스트 개수만큼 반복
		for (int t = 0; t < T; t++) {
			// 맵 입력
			M = scan.nextInt();
			N = scan.nextInt();
			int K = scan.nextInt();
			map = new int[M][N];
			for (int i = 0; i < K; i++) {
				int r = scan.nextInt();
				int c = scan.nextInt();
				map[r][c] = 1;
			}
			
			// dfs ㄱㄱ
			int count = 0;
			visited = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i,j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
	
	static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for (int i = 0; i < pos.length; i++) {
			int nr = r + pos[i][0];
			int nc = c + pos[i][1];
			if(nr>=0 && nr<M && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
	
}

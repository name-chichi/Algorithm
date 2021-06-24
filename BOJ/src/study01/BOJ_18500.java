package study01;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_18500 {
	static int R, C; // 동굴의 크기
	static char[][] map; // 동굴
	static int[][] pos = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상,하,좌,우
	static boolean[][] visited;
	static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = scan.next();
			map[i] = str.toCharArray();
		}

		int N = scan.nextInt(); // 막대를 던진 횟수
		for (int i = 0; i < N; i++) {
			// 입력할 때 R-height 으로 ㄱㄱ
			int height = R - scan.nextInt();
			game(i % 2, height);
		}
		printMap();	// 결과 출력
	}

	// 미네랄이 있다면
	// 1. 미네랄 깨트리고
	// 2. 뿌리랑 연결되어 있는지 확인 후
	// 3. 연결 안되어 있다면 밑으로 다운
	static void game(int dir, int height) {
		if (dir == 0) {
			// 왼쪽
			for (int i = 0; i < C; i++) {
				if (map[height][i] == 'x') {
					map[height][i] = '.';
					break;
				}
			}
		} else {
			// 오른쪽
			for (int i = C - 1; i >= 0; i--) {
				if (map[height][i] == 'x') {
					map[height][i] = '.';
					break;
				}
			}
		}
		findRootCluster();
		down();
	}


	static void down() {
		// 위에 있는 클러스터 찾기
		list.clear();
		for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (map[i][j] == 'x' && !visited[i][j]) list.add(new int[] {i,j});
		
		// 전에 있던 클러스터 지우기
		for (int[] arr : list) map[arr[0]][arr[1]] = '.';
		
		// 얼만큼 떨어질지 거리 구하기
		int distance = 0;
		outer: for (int i = 1; i < R; i++) {
			for (int[] arr : list) {
				int r = arr[0] + i;
				int c = arr[1];
				if(r>=R || map[r][c] == 'x') {
					distance = i-1;
					break outer;
				}
			}
		}
		// 밑으로 떨어지기
		for (int[] arr : list) map[arr[0]+distance][arr[1]] = 'x';
	}

	static void findRootCluster() {
		visited = new boolean[R][C];
		// 땅에 붙어있는 애들 찾기
		for (int i = 0; i < C; i++) if (map[R - 1][i] == 'x') dfs(R - 1, i);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int p = 0; p < pos.length; p++) {
			int nr = r + pos[p][0];
			int nc = c + pos[p][1];
			if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 'x') dfs(nr, nc);
		}
	}
	
	static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) System.out.print(map[i][j]);
			System.out.println();
		}
	}

}
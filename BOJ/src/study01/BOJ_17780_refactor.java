package study01;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_17780_refactor {
	static final int WHITE = 0;
	static final int RED = 1;
	static final int BLUE = 2;
	static final int[][] pos = {{0,1},{0,-1},{-1,0},{1,0}};	// 우,좌,상,하
	static final int[] change_dir = {1,0,3,2};	// 좌,우,하,상
	
	static int N;
	static int K;
	static int[][] map;
	static LinkedList<Integer>[][] state;	// 한 좌표에 어떤 체스말이 담겨있는지 기록
	static Chess[] chessArr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		map = new int[N][N];
		state = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
				state[i][j] = new LinkedList<>();
			}
		}

		chessArr = new Chess[K+1];
		for(int i=1; i<=K; i++) {
			int r = scan.nextInt()-1;
			int c = scan.nextInt()-1;
			int dir = scan.nextInt()-1;
			chessArr[i] = new Chess(r,c,dir);
			state[r][c].add(i);
		}
		int result = game();
		System.out.println(result);
	}
	
	static int game() {
		boolean flag = false;
		int time = 0;
		while(!flag) {
			time++;
			if(time > 1000) break;
			for(int i=1; i<=K; i++) {
				Chess chess = chessArr[i];
				int r = chess.r;
				int c = chess.c;
				
				// 맨 밑에 있는 것이 아니라면 넘어간다.
				if(state[r][c].size()==0 || state[r][c].get(0) != i) continue;
				
				int nr = r + pos[chess.dir][0];
				int nc = c + pos[chess.dir][1];
				
				// 그다음 좌표가 맵 범위 밖이거나 파란색일때
				if(!isRange(nr,nc) || map[nr][nc] == BLUE) {
					// 방향 반대
					chess.dir = change_dir[chess.dir];
					nr = r + pos[chess.dir][0];
					nc = c + pos[chess.dir][1];
				}
				if(!isRange(nr,nc) || map[nr][nc] == BLUE) continue;
				else if(map[nr][nc] == RED) {
					// 빨간색이라면
					for(int j = state[r][c].size()-1; j>=0; j--) {
						int idx = state[r][c].get(j);
						state[nr][nc].add(idx);
						chessArr[idx].r = nr;
						chessArr[idx].c = nc;
					}
					state[r][c].clear();
				} else {
					// 흰색이면
					for(int j = 0; j<state[r][c].size(); j++) {
						int idx = state[r][c].get(j);
						state[nr][nc].add(idx);
						chessArr[idx].r = nr;
						chessArr[idx].c = nc;
					}
					state[r][c].clear();
				}
				
				// 말이 4개 이상이라면 게임끝
				if(state[nr][nc].size() >= 4) {
					flag = true;
					break;
				}
			}
		}
		return flag ? time : -1;
	}
	
	static class Chess {
		int r,c,dir;

		public Chess(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
	
	static boolean isRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
}

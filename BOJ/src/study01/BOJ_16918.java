package study01;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16918 {
	static int R,C,N;	// 행,열,초
	static char[][] map;	// 맵
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};	// 상,하,좌,우
	static ArrayList<int[]> bombList;	// 폭탄 위치 담는 리스트
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		R = scan.nextInt();
		C = scan.nextInt();
		N = scan.nextInt();
		map = new char[R][C];
		bombList = new ArrayList<>();
		
		for (int i = 0; i < R; i++) map[i] = scan.next().toCharArray();
		
		// 처음 1초는 봄버맨이 아무것도 하지 않기 때문에 1부터 시작
		for(int tc=1; tc<N; tc++) {
			if(tc % 2 == 1) bombInstall();	// 폭탄 설치하기
			else bombExplode();	// 폭탄 터트리기
		}
		printMap();
		
	}
	
	// 폭탄 설치
	static void bombInstall() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == '.') map[i][j] ='O';
				else bombList.add(new int[] {i,j});
			}
		}
	}
	
	// 폭탄 터트리기
	static void bombExplode() {
		for (int[] bombPos : bombList) {
			int r = bombPos[0];
			int c = bombPos[1];
			map[r][c] = '.';
			
			for(int i=0; i<pos.length; i++) {
				int nr = r + pos[i][0];
				int nc = c + pos[i][1];
				if(nr>=0 && nr<R && nc>=0 && nc<C) map[nr][nc] = '.';
			}
		}
		bombList.clear();
	}
	
	static void printMap() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
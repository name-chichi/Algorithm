package study01;

import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_17780 {
	static int N;
	static int[][] pos = {{0,1},{0,-1},{-1,0},{1,0}};	// 우,좌,상,하 : 0,1,2,3
	static int[][] reverse_pos = {{0,-1},{0,1},{1,0},{-1,0}};	// 좌,우,하,상 : 0,1,2,3
	static Chess[] chessArr;
	static boolean chkLen;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int K = scan.nextInt();
		
		Map[][] map = new Map[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Map(i,j,scan.nextInt());
			}
		}
		
		chessArr = new Chess[K];
		for (int i = 0; i < K; i++) {
			int row = scan.nextInt()-1;
			int col = scan.nextInt()-1;
			int direction = scan.nextInt()-1;
			chessArr[i] = new Chess(i, row, col, direction);
			map[row][col].list.add(i);
		}
		
		int count = 0;
		while(count < 1000) {
			Game(chessArr, map);
			count++;
			if(chkLen) break;
		}
		if(chkLen) System.out.println(count);
		else System.out.println(-1);
	}
	
	static void printMap(Map[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j].list.size() + " ");
			}
			System.out.println();
		}
		
	}
	
	static void printChessArr() {
		for (Chess chess : chessArr) {
			System.out.print(chess.no+ "," + chess.move + " | ");
		}
		System.out.println();
	}
	
	static void Game(Chess[] chessArr, Map[][] map) {
		for (Chess chess : chessArr) {
			// System.out.println("체스 번호 : " + chess.no + ", 체스 방향 : " + chess.direction + ", 체스 무빙 : " + chess.move);
			// printMap(map);
			// printChessArr();
			if(chess.move) {
				// 이동할수 있는 체스라면
				int direction = chess.direction;
				int nRow = chess.row + pos[direction][0];
				int nCol = chess.col + pos[direction][1];
				// System.out.println("앞으로 움직일 위치 : (" + nRow + "," + nCol + ")");
				if(nRow>=0 && nRow<N && nCol>=0 && nCol<N) {
					// System.out.println(" 색깔 : " + map[nRow][nCol].color);
					// 그대로 진행
					if(map[nRow][nCol].color == 0) {
						// 흰색
						whiteRule(chess, map);
					} else if(map[nRow][nCol].color == 1) {
						// 빨간색
						redRule(chess, map, chessArr);
					} else {
						// 파란색
						blueRule(chess, map, chessArr);
					}
				} else {
					// 이동할 곳이 맵 밖으로 나가게 된다면
					// 파란색 반영
					blueRule(chess, map, chessArr);
				}
				
				
			}
		}
	}
	
	static void blueRule(Chess chess, Map[][] map, Chess[] chessArr) {
		int direction = chess.direction;
		int reverseRow = chess.row + reverse_pos[direction][0];
		int reverseCol = chess.col + reverse_pos[direction][1];
		// System.out.println("앞으로 움직일 위치 : (" + reverseRow + "," + reverseCol + ")");
		if(reverseRow>=0 && reverseRow<N && reverseCol>=0 && reverseCol<N) {
			// System.out.println(" 색깔 : " + map[reverseRow][reverseCol].color);
			// 역방향이 맵 범위안에 들었다면 이동!
			if(map[reverseRow][reverseCol].color == 0) {
				whiteReverseRule(chess, map);
			} else if(map[reverseRow][reverseCol].color == 1) {
				redReverseRule(chess, map, chessArr);
			} else {
				// 또 파란색이면 방향만 바꾸고 안움진인다.
				if(direction == 0 || direction == 2) {
					chess.direction += 1;
				} else {
					chess.direction -= 1;
				}
			}
		}
	}
	
	static void redReverseRule(Chess chess, Map[][] map, Chess[] chessArr) {
		int direction = chess.direction;
		int prevRow = chess.row;
		int prevCol = chess.col;
		int reverseRow = chess.row + reverse_pos[direction][0];
		int reverseCol = chess.col + reverse_pos[direction][1];
		if(direction == 0 || direction == 2) {
			chess.direction += 1;
		} else {
			chess.direction -= 1;
		}
		
		chess.row = reverseRow;
		chess.col = reverseCol;
		map[prevRow][prevCol].list = reverseList(map[prevRow][prevCol].list);
		chess.move = false;
		if(map[reverseRow][reverseCol].list.size() == 0) {
			// 이동하는 칸에 체스가 없다면
			// 역순으로 돌려놓은 체스리스트에서 맨 아래에 있는 놈을 움직일 수 있게 flag 바꾼다.
			chessArr[map[prevRow][prevCol].list.get(0)].move = true;
		}
		for(int no : map[prevRow][prevCol].list) {
			chessArr[no].row = reverseRow;
			chessArr[no].col = reverseCol;
		}
		map[reverseRow][reverseCol].list.addAll(map[prevRow][prevCol].list);
		map[prevRow][prevCol].list.clear();
		if(map[reverseRow][reverseCol].list.size() >= 4) chkLen = true;
	}
	
	static void whiteReverseRule(Chess chess, Map[][] map) {
		int direction = chess.direction;
		int prevRow = chess.row;
		int prevCol = chess.col;
		int reverseRow = chess.row + reverse_pos[direction][0];
		int reverseCol = chess.col + reverse_pos[direction][1];
		if(direction == 0 || direction == 2) {
			chess.direction += 1;
		} else {
			chess.direction -= 1;
		}
		
		if(map[reverseRow][reverseCol].list.size() > 0) {
			// 칸에 체스가 존재하고 있으면
			chess.move = false;
		}
		for(int no : map[prevRow][prevCol].list) {
			chessArr[no].row = reverseRow;
			chessArr[no].col = reverseCol;
		}
		map[reverseRow][reverseCol].list.addAll(map[prevRow][prevCol].list);
		map[prevRow][prevCol].list.clear();
		if(map[reverseRow][reverseCol].list.size() >= 4) chkLen = true;
	}
	
	static void whiteRule(Chess chess, Map[][] map) {
		int direction = chess.direction;
		int prevRow = chess.row;
		int prevCol = chess.col;
		int nRow = chess.row + pos[direction][0];
		int nCol = chess.col + pos[direction][1];
		
		if(map[nRow][nCol].list.size() > 0) {
			// 칸에 체스가 존재하고 있으면
			chess.move = false;
		}
		for(int no : map[prevRow][prevCol].list) {
			chessArr[no].row = nRow;
			chessArr[no].col = nCol;
		}
		map[nRow][nCol].list.addAll(map[prevRow][prevCol].list);
		map[prevRow][prevCol].list.clear();
		if(map[nRow][nCol].list.size() >= 4) chkLen = true;
	}
	
	static void redRule(Chess chess, Map[][] map, Chess[] chessArr) {
		int direction = chess.direction;
		int prevRow = chess.row;
		int prevCol = chess.col;
		int nRow = chess.row + pos[direction][0];
		int nCol = chess.col + pos[direction][1];
		
		map[prevRow][prevCol].list = reverseList(map[prevRow][prevCol].list);
		chess.move = false;
		if(map[nRow][nCol].list.size() == 0) {
			// 이동하는 칸에 체스가 없다면
			// 역순으로 돌려놓은 체스리스트에서 맨 아래에 있는 놈을 움직일 수 있게 flag 바꾼다.
			chessArr[map[prevRow][prevCol].list.get(0)].move = true;
		}
		for(int no : map[prevRow][prevCol].list) {
			chessArr[no].row = nRow;
			chessArr[no].col = nCol;
		}
		map[nRow][nCol].list.addAll(map[prevRow][prevCol].list);
		map[prevRow][prevCol].list.clear();
		if(map[nRow][nCol].list.size() >= 4) chkLen = true;
	}
	
	static void moveListElement() {
		
	}
	
	static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
		LinkedList<Integer> newList = new LinkedList<Integer>();
		for(int i=list.size()-1; i>=0; i--) {
			newList.add(list.get(i));
		}
		return newList;
	}
	
	static class Map {
		int r;
		int c;
		int color;	// 0 흰색, 1 빨간색, 2 파란색
		LinkedList<Integer> list;
		
		public Map(int r, int c, int color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
			list = new LinkedList<Integer>();
		}
	}
	
	static class Chess {
		int no;
		int row;
		int col;
		int direction;
		boolean move;
		
		public Chess(int no, int row, int col, int direction) {
			super();
			this.no = no;
			this.row = row;
			this.col = col;
			this.direction = direction;	 // 우,좌,상,하 : 1,2,3,4
			this.move = true;
		}

		@Override
		public String toString() {
			return "Chess [row=" + row + ", col=" + col + ", direction=" + direction + "]";
		}
	}
	
	
}

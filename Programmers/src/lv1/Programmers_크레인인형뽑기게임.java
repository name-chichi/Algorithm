package lv1;

import java.util.Stack;

public class Programmers_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};	// 게임 화면
		int[] moves = {1,5,3,5,1,2,1,4};	// 작동시킨 위치 배열
		
		Stack<Integer> stack = new Stack<Integer>();	// 바구니
		int result = 0;		// 터트린 인형의 개수
		
		// 작동시킨만큼 순회
		for (int i = 0; i < moves.length; i++) {
			int loc = moves[i]-1;
			for (int j = 0; j < board.length; j++) {
				if(board[j][loc] != 0) {	// 뽑기위치에 인형이 있다면
					int tmp = board[j][loc];	
					board[j][loc] = 0;	// 뽑인 곳은 인형 없애기
					if(!stack.isEmpty()) {	// 바구니가 비어있지 않다면
						if(stack.peek() == tmp) {	// 맨위에 있는 인형이랑 같은지 확인! -> 같으면 바구니 하나 비우기
							stack.pop();
							result+=2;
						} else stack.push(tmp); // 맨위에 있는 인형이랑 같지 않으면 바구니에 넣기
					} else stack.push(tmp); // 바구니가 비어있는 상태라면 바구니에 인형 넣기
					break;	// 인형뽑기 했으면 그 다음 위치로 이동
				}
			}
		}
		System.out.println(result);
	}
}

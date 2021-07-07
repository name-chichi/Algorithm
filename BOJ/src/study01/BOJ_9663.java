package study01;

import java.util.Scanner;

public class BOJ_9663 {
	static int N;
	static int[] chess;
	static int count = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		chess = new int[N];
		nQueen(0);
		System.out.println(count);
	}
	
	static void nQueen(int colIdx) {
		if(colIdx == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			chess[colIdx] = i;
			if(isPromising(colIdx)) {
				nQueen(colIdx+1);
			}
		}
	}
	
	static boolean isPromising(int colIdx) {
		for(int i=0; i<colIdx; i++) {
			if(chess[i] == chess[colIdx] || colIdx-i == Math.abs(chess[colIdx]-chess[i])) {
				return false;
			}
		}
		return true;
	}
	
}

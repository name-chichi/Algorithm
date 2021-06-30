package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16967 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		int[][] B = new int[H+X][W+Y];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W+Y; j++) B[i][j] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				A[i][j] = B[i][j];
				if(i>=X && i<H+X && j>=Y && j<W+Y) A[i][j] -= A[i-X][j-Y];
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

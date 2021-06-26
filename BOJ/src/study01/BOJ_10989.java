package study01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10989 {
	public static void main(String[] args) throws IOException {
		// 1. Scanner scan 으로 입력 X
		// 2. 카운팅 정렬
		// 3. sysout 으로 출력 X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			arr[input]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			for (int j = 0; j < arr[i]; j++) {
				sb.append(i + "\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

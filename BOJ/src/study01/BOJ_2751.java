package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i : arr) sb.append(i).append("\n");
		System.out.println(sb);
		
		/*

		sol1. Collection Sort 사용 => Tim sort
		sol2. BufferedReader 사용
		sol3. Counting Sort 사용

		퀵소트는 최악 조건시 O(n2)이 나온다.
		+ 추가적으로 StringBuilder를 써주자!!
		
		*/
	}
}

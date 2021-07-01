package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_loop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 숫자 카드 갯수
		int[] arr = new int[N];	// 숫자 카드 배열
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);	// 숫자 카드 정렬
		
		int M = Integer.parseInt(br.readLine());
		int[] answerArr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			answerArr[i] = binarySearch(arr, card);	// 숫자 카드에 상근이 가지고 있는 카드가 존재하는지 체크
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) sb.append(answerArr[i]).append(" ");
		System.out.println(sb);
	}
	
	// 이진 탐색
	static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] == target) return 1;
			else if(arr[mid] > target) end = mid - 1;
			else start = mid + 1;
		}
		return 0;
	}
}
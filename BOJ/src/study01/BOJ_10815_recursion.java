package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_recursion {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		int[] inputArr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) inputArr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String answer = binarySearch(0, N-1, inputArr[i]) ? "1 " : "0 ";
			sb.append(answer);
		}
		System.out.println(sb);
	}
	
	static boolean binarySearch(int start, int end, int goal) {
		if(start > end)	return false;
		
		int mid = (start + end) / 2;
		if(arr[mid] == goal) {
			return true;
		} else if(arr[mid] > goal) {
			return binarySearch(start, mid-1, goal);
		} else if(arr[mid] < goal) {
			return binarySearch(mid+1, end, goal);
		}
		return false;
	}
	
}

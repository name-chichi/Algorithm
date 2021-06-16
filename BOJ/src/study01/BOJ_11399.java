package study01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
		Arrays.sort(arr);
		
		int sum = 0;
		int result = 0;
		for (int i : arr) {
			sum += i;
			result += sum;
		}
		System.out.println(result);
	}
}

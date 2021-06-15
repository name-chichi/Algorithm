package study01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = scan.nextInt();
		Arrays.sort(arr);
		for (int i : arr) System.out.println(i);
	}
}

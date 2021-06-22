package study01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_11651_refactoring {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for (int i = 0; i < N; i++) System.out.println(arr[i][0] + " " + arr[i][1]);
	}
}

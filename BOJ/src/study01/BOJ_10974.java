package study01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10974 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<arr.length; i++) arr[i]=i+1;
		perm(arr, new int[n], new boolean[n], 0);
	}
	
	public static void perm(int[] arr, int[] sel, boolean[] visited, int r) {
		if(r == sel.length) {
			String str = "";
			for(int num : sel) str += (num + " "); 
			System.out.println(str.substring(0, str.length()-1));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				sel[r] = arr[i];
				visited[i] = true;
				perm(arr, sel, visited, r+1);
				visited[i] = false;
			}
		}
	}

}

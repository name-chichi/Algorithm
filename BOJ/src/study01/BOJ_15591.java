package study01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_15591 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		
		ArrayList<int[]>[] graph = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) graph[i] = new ArrayList<int[]>();
		
		for(int i=0; i<N-1; i++) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			int r = scan.nextInt();
			
			graph[p].add(new int[] {q,r}); 
			graph[q].add(new int[] {p,r});
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int t=0; t<Q; t++) {
			int k = scan.nextInt();
			int v = scan.nextInt();
			
			boolean[] visited = new boolean[N+1];
			queue.add(v);

			int result = 0;
			while(!queue.isEmpty()) {
				int vertex = queue.poll();
				visited[vertex] = true;
				for(int i=0; i<graph[vertex].size(); i++) {
					int[] usadoArr = graph[vertex].get(i);
					if(!visited[usadoArr[0]] && k <= usadoArr[1]) {
						queue.add(usadoArr[0]);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
}
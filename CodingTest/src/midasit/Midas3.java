package midasit;

import java.util.Arrays;
import java.util.Comparator;

public class Midas3 {
	public static void main(String[] args) {
		Midas3 m3 = new Midas3();
		int N = 6;
		int K = 4;
		int[][] T = {{1,3},{3,4},{2,4},{2,4},{2,3},{1,2}};
		// {{1,3},{1,1},{2,3},{3,4}};
		// {{1,3},{3,4},{2,4},{2,4},{2,3},{1,2}};
		System.out.println(m3.solution(N, K, T));
	}
	
	public int solution(int N, int K, int [][]T) {
        Arrays.sort(T, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
        });
        
        for(int i=0; i<T.length; i++) {
        	System.out.println(Arrays.toString(T[i]));
        }
        
        int answer = 0;
        boolean[] studentArr = new boolean[N+1];
        for(int i=1; i<=K; i++) {
        	for(int t=0; t<T.length; t++) {
        		if(!studentArr[t+1] && T[t][0] <= i && T[t][1] >= i) {
        			answer++;
        			studentArr[t+1] = true;
        			break;
        		}
        	}
        }
        return answer;
    }
}

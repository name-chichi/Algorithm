package midasit;

import java.util.ArrayList;

public class Midas2 {
	int prize = Integer.MIN_VALUE;
	int tmpPrize;
	int minStdNum;
	boolean[] visited;
	public static void main(String[] args) {
		Midas2 m2 = new Midas2();
		int n = 6;
		int[] v1 = {1, 5, 3, 6, 2};
		int[] v2 = {5, 4, 6, 2, 3};
		int[] num = {1, 5, 4, 3, 6, 2};
		int[] amount = {3, 6, -2, 2, 2, 2};
		System.out.println(m2.solution(n, v1, v2, num, amount));
	}
	
	public int solution(int n, int[] v1, int[] v2, int[] num, int[] amount) {
        int answer = 0;
        
        ArrayList<Integer>[] groupList = new ArrayList[n+1];	// 그룹 리스트 배열
        int[] prizeArr = new int[n+1];	// 학생 번호순 상벌점 배열
        visited = new boolean[n+1];
        
        for(int i=1; i<=n; i++) {
        	groupList[i] = new ArrayList<>();	// 그룹 리스트 배열 초기화
        }
        
        for(int i=0; i<v1.length; i++) {
        	groupList[v1[i]].add(v2[i]);
        	groupList[v2[i]].add(v1[i]);
        }
        
        for(int i=0; i<num.length; i++) {
        	prizeArr[num[i]] += amount[i];
        }
        
        for(int i=1; i<=n; i++) {
        	if(!visited[i]) {
        		tmpPrize = 0;
        		dfs(i, groupList, prizeArr);
        		if(prize < tmpPrize) {
        			prize = tmpPrize;
        			minStdNum = i;
        		}
        	}
        }
        
        answer = minStdNum;
        return answer;
    }
	
	public void dfs(int student, ArrayList<Integer>[] groupList, int[] prizeArr) {
		visited[student] = true;
		tmpPrize += prizeArr[student];

		for (int tmp : groupList[student]) {
			if(!visited[tmp]) dfs(tmp, groupList, prizeArr);
		}
	}
}

package lv1;

public class Programmers_수박수박수박수박수박수 {
	public static void main(String[] args) {
		int n = 3;
		char[] charArr = {'수', '박'};
		String answer = "";
		for(int i=0; i<n; i++) answer += charArr[i%2];
		System.out.println(answer);
	}
}

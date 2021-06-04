package lv1;

public class Programmers_짝수와홀수 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String str = sol.solution(3);
		System.out.println(str);
	}
}

class Solution {
    public String solution(int num) {
        String answer = "";
        answer = (num % 2 == 0) ? "Even" : "Odd";	// 삼항 연산자
        return answer;
    }
}
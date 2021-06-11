package lv1;

public class Programmers_내적 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		int result = 0;
		
		for (int i = 0; i < a.length; i++) result += (a[i]*b[i]);
		System.out.println(result);
	}
}

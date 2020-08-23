import java.util.Scanner;
public class A_Graph_Problem {
	public static void main(String[]args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		double sum = 0;
		double max = 0;
		for (int i =0; i<n; i++) {
			double input = sc.nextInt();
			sum+= input;
			max = Math.max(max, input);
		}
		//System.out.println(sum+"\t"+max);
		if (sum%2==0 && sum-max>=max) {
			System.out.println("YES");
		}
		else
		System.out.println("NO");
	}
}
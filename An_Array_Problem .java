import java.util.Scanner;
public class An_Array_Problem {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x;
		long sum =0;
		int max = -1;
		for (int i =0; i<n; i++) {
			x=sc.nextInt();
			sum+=x;
			max = Math.max(max,x);
		}
		long rest = sum-max;
		if (rest>=max)
			System.out.println(sum/2);
		else
			System.out.println(rest);
	}
}
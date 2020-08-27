import java.util.Scanner;
public class Deforestation {
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int sum[]=new int[n+1];
		sum[0]=0;
		for (int i=1; i<n+1; i++) {
			int term = sc.nextInt();
			sum[i]=term+sum[i-1];
		}
		int q  =sc.nextInt();
		int a;
		int b;
		for (int i =0; i<q; i++) {
			a =sc.nextInt();
			b =sc.nextInt();
			System.out.println(sum[b+1]-sum[a]);
		}
	}
}
public class BigDeposits {
	static long p , y, t;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		 p = sc.nextLong();
		 y = sc.nextLong();
		 t = sc.nextLong();
		 long lo =1, hi = t, ans = 0;
		 while (lo<=hi) {
			 long mid = (lo+hi)/2;
			 if (check(mid)) {ans = mid; hi = mid -1;}
			 else
				 lo =mid+1;
		 }

			System.out.println(ans);
	}
	static boolean check (long x) {
		long tot = 0;
		for (int i =0; i<y;i++) {
			tot+=x;
			tot+=tot*p/100;
			if (tot>=t) return true;
		}
		return tot>=t;
	}
}
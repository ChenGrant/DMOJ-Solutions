import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Love_Guru {
	public static void main(String[]args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine().toLowerCase();
		String b = br.readLine().toLowerCase();
		int sumA = 0;
		int sumB = 0;
		for (int i =0; i<a.length(); i++) {
			sumA +=lastDigit(a.charAt(i)-96, i+1);
			//System.out.println(lastDigit(a.charAt(i)-96, i+1));
			if (sumA>10)
				sumA= sumA%10;
		}
		if (sumA==0)
			sumA=10;
		//System.out.println("sumA is "+sumA);
		for (int i =0; i<b.length(); i++) {
			sumB +=lastDigit(b.charAt(i)-96, i+1);
			//System.out.println(lastDigit(b.charAt(i)-96, i+1));
			if (sumB>10)
				sumB= sumB%10;
		}
		if (sumB==0)
			sumB=10;
		//System.out.println("sumB is "+sumB);
		System.out.println(sumA+sumB);
	}
	public static int lastDigit (int base, int exp) {
		int lastDigit=0;
		int sum = 0;
		if (exp%4==0)
			sum = ((int)Math.pow(base%10,(4)));
		else
			sum = ((int)Math.pow(base%10,exp%4));
		if (sum>=11)
			lastDigit=sum%10;
		else
			lastDigit = sum;
		return lastDigit;
	}
}
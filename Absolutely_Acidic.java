import java.io.*;
import java.util.*;

public class Absolutely_Acidic {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int freq[] = new int[1001];
		for (int i = 0; i < n; i++) {
			freq[readInt()]++;
		}
		int max = 0;
		int high = 0;
		int low = 0;
		for (int i = 1; i <= 1000; i++) {
			if (freq[i] > max) {
				max = freq[i];
				high = i;
				low = i;
			} else if (freq[i] == max)
				high = i;
		}
		//System.out.println("Hi "+max+" "+high+" "+low);
		if (high != low) {
			System.out.println((high - low));
		} else {
			int max2 = 0;
			int high2 = 0;
			int low2 = 0;
			for (int i = 1; i <= 1000; i++) {
				if (freq[i] < max && freq[i]>max2) {
					max2 = freq[i];
					high2 = i;
					low2 = i;
				} else if (freq[i]<max &&freq[i] == max2)
					high2 = i;
			}
			System.out.println(Math.max(Math.abs(high - high2), Math.abs(high - low2)));

		}
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
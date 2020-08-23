import java.io.*;
import java.util.*;

public class Mimi_and_Primes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		long first = readLong();
		long maxFactor = first;
		for (int i = 0; i < n - 1; i++) {
			long input = readLong();
			maxFactor = gcd(maxFactor, input);
		}
		if (maxFactor == 1) {
			System.out.println("DNE");
		} else {
			for (int i = 2; i <=Math.sqrt(maxFactor); i++) {
				if (maxFactor % i == 0) {
					maxFactor = maxFactor / i;
					i--;
				}
			}
			System.out.println(maxFactor);
		}
	}

	public static long gcd(long p, long q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
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
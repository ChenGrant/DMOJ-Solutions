import java.util.*;
import java.io.*;

public class SumofPrimes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = 10000000;
	static boolean[] isPrime = new boolean[max];

	public static void main(String[] args) throws IOException {
		for (int f = 0; f < 5; f++) {
			int n = readInt();
			sieve();
			boolean two = false;
			boolean three = false;
			if (isPrime[n]) {
				System.out.println(n+" = "+n);
			} else {
				for (int i = n / 2; i > 2; i--) {
					if (isPrime[i] && isPrime[n - i]) {
						System.out.println(n + " = " + i + " + " + (n - i));
						two = true;
						break;
					}
				}
				if (!two) {
					for (int i = n / 3; i > 2; i--) {
						for (int z = n; z >= i; z--) {
							if (i <= z && z <= n - i - z && isPrime[i] && isPrime[z] && isPrime[n - i - z]) {
								System.out.println(n + " = " + i + " + " + z + " + " + (n - i - z));

								three = true;
								break;
							}
						}
						if (three)
							break;
					}
				}
				if (!three && !two)
					System.out.println(n + " = " + n);
			}
		}
	}

	static void sieve() {
		for (int i = 2; i < max; i++) {
			isPrime[i] = true;
		}
		for (int i = 2; i < max; i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < max; j += i) {
					isPrime[j] = false;
				}
			}
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

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
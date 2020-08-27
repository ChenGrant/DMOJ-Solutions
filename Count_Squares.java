import java.io.*;
import java.util.*;

public class Count_Squares {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int h = readInt();
		int v = readInt();

		int y[] = new int[h], x[] = new int[v];
		long ans = 0;
		Map<Integer, Integer> freq = new HashMap();
		for (int i = 0; i < h; i++) {
			y[i] = readInt();
			for (int j = 0; j < i; j++) {
				freq.put(y[j] - y[i], freq.getOrDefault(y[j] - y[i], 0) + 1);
			}

		}
		for (int i = 0; i < v; i++) {
			x[i] = readInt();
			for (int j = 0; j < i; j++) {
				ans += freq.getOrDefault(x[j] - x[i], 0);
			}
		}
		System.out.println(ans);

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
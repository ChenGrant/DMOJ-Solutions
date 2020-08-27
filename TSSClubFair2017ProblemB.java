import java.util.*;
import java.io.*;

public class TSSClubFair2017ProblemB {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		double houses[][] = new double[n][2];
		double distances[] = new double[n];
		for (int i = 0; i < n; i++) {
			houses[i][0] = readInt();
			houses[i][1] = readInt();
			distances[i] = Math.sqrt(houses[i][0] * houses[i][0] + houses[i][1] * houses[i][1]);
		}
		Arrays.sort(distances);
		for (int i = 0; i < q; i++) {
			int r = readInt();
			int low = 0;
			int high = n - 1;
			int mid = (low + high) / 2;
			if (distances[low] >= r) {
				System.out.println(0);
				continue;
			} else if (distances[high] <= r) {
				System.out.println(n);
				continue;
			} else {
				while (true) {
					mid = (low + high) / 2;
					if (distances[mid] < r && r < distances[mid + 1] || distances[mid] == r) {
						System.out.println(mid + 1);
						break;
					}
					else if (r > distances[mid]) {
						low = mid + 1;
					} else if (r < distances[mid]) {
						high = mid - 1;
					}
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

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
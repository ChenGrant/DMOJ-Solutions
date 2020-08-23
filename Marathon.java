import java.util.*;
import java.io.*;
public class Marathon {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		int rate[] = new int[n+1];
		rate[0] = 0;
		rate[1] = readInt();
		for (int i =2; i<=n; i++) {
			rate[i] = readInt();
			rate[i]+=rate[i-1];
			
		}
		for (int z =0; z<q; z++) {
			int a = readInt();
			int b = readInt();
			if (a==1&& b==n) {
				System.out.println(0);
			}
			else {
				//System.out.println(rate[n]+" "+rate[b+1]+" "+rate[a-1]);
				System.out.println(rate[n]-rate[b]+rate[a-1]);
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
import java.io.*;
import java.util.*;

public class Traktor {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int MV = 100000;
		int n = readInt();
		int k = readInt();
		int row []= new int [MV];
		int col []= new int[MV];
		int left[]= new int [2*MV-1];
		int right []= new int [2*MV-1];
		for (int i =1; i<=n; i++) {
			int r = readInt()-1;
			int c  = readInt()-1;
			row[r]++;
			col[c]++;
			left[r+c]++;
			right[r+n-1-c]++;
			if (row[r]==k||col[c]==k||left[r+c]==k||right[r+n-1-c]==k) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
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
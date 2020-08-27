import java.io.*;
import java.util.*;

public class BattlePositions {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), min = readInt(), m = readInt(), dif[] = new int[n+2];
		for (int i =1; i<=m; i++) {
			int x = readInt(), y = readInt(), v = readInt();
			dif[x]+=v;
			dif[y+1]-=v;
		}
		int ans =0;
		for (int i =1; i<=n;i++) {
			dif[i]+=dif[i-1];
			if (dif[i]<min)
				ans++;
		}
		System.out.println(ans);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
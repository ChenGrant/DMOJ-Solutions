import java.util.*;
import java.io.*;
public class Test10 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), freq[] = new int[2001];
		for(int i=0; i<n; i++) freq[readInt()]++;
		int board [] = new int[4001];
		for(int i=1; i<=4000; i++) {
			for(int x=1; x*2 < i; x++) {
				int y = i - x;
				if(x <= 2000 && y <= 2000) 
					board[i] += Math.min(freq[x], freq[y]);
			}
			if(i % 2 == 0) board[i] += freq[i/2]/2;
		}
		int ans = 0, cnt = 0;
		for(int i=1; i<=4000; i++) {
			if(board[i] > ans) { ans = board[i]; cnt = 1; }
			else if(board[i] == ans) cnt++;
		}
		System.out.println(ans + " " + cnt);
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
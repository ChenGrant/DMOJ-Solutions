import java.util.*;
import java.io.*;
public class Test5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int N, M; static boolean adj[][], vis[], cycle;
	public static void main(String[] args) throws IOException {
		N = readInt(); M = readInt(); adj = new boolean[N+1][N+1]; vis = new boolean[N+1];
		for(int i=1; i<=M; i++) {
			int u = readInt(), v = readInt();
			adj[u][v] = true;  adj[v][u] = true;
		}
		for(int i=1; i<=N; i++) {
			Arrays.fill(vis, false);
			dfs(i, i, 1);
			if(cycle) { System.out.println("YES"); return; }
		}
		System.out.println("NO");
	}
	static void dfs(int start, int cur, int d) {
		vis[cur] = true;
		for(int nxt = 1; nxt <= N; nxt ++) {
			if(!adj[cur][nxt]) continue;
			if(nxt == start && d == 6) { cycle = true; return; }
			if(!vis[nxt]) dfs(start, nxt, d + 1);
		}
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
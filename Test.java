import java.util.*;
import java.io.*;
public class Test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int N, len, far, par[], cost[]; static List<edge> adj[];
	public static void main(String[] args) throws IOException {
		N = readInt(); adj = new ArrayList[N+1]; par = new int[N+1]; cost = new int[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList();
		for(int i=1; i<N; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new edge(v, w)); adj[v].add(new edge(u, w));
		}
		len = -1; dfs(1, 0, 0); int p1 = far;
		len = -1; dfs(p1, 0, 0); int p2 = far, diameter = len, radius = len;
		for(int i=p2, left=0; i!=p1; i=par[i]) {
			int right = diameter - left;
			radius = Math.min(radius, Math.max(left, right));
			left += cost[i];
		}
		System.out.println(diameter + "\n" + radius);
	}
	static void dfs(int u, int pre, int dis) {
		if(dis > len) { len = dis; far = u; }
		for(edge e: adj[u]) {
			int v = e.v, w = e.w; 
			if(v != pre) {
				par[v] = u; cost[v] = w; dfs(v, u, dis+w);
			}
		}
	}
	static class edge{
		int v, w;
		edge(int v0, int w0) { v = v0; w = w0; }
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
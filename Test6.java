import java.util.*;
import java.io.*;
public class Test6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static int far, n; static List<pair> adj[]; static long dis[];
	public static void main(String[] args) throws IOException {
		n = readInt();   adj = new ArrayList[n+1];  dis = new long[n+1];
		for(int i=1; i<=n; i++) adj[i] = new ArrayList<pair>();
		for(int i=1; i<n; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new pair(v, w)); adj[v].add(new pair(u, w));
		}
		bfs(1); int p1 = far; bfs(p1);  int p2 = far; long ans = 0;
		for(int i=1; i<=n; i++)
			if(i != p2) ans = Math.max(ans, dis[i]);
		bfs(p2); 
		for(int i=1; i<=n; i++)
			if(i != p1) ans = Math.max(ans, dis[i]);
		System.out.println(ans);
	}
	static void bfs(int st) {
		Queue<Integer> q = new LinkedList(); 
		boolean vis[] = new boolean[n+1]; long len = 0;
		q.add(st); dis[st] = 0; vis[st] = true;
		while(!q.isEmpty()) {
			int cur = q.poll(); 
			if(dis[cur] > len) { len = dis[cur];  far = cur;}
			for(pair e: adj[cur]) {
				if(!vis[e.v]) { q.add(e.v); vis[e.v]=true; dis[e.v] = dis[cur] + e.w; }
			}
		}
	}
	static class pair {
		int v, w;
		pair(int v0, int w0) { v = v0; w = w0; }
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
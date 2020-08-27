import java.util.*;
import java.io.*;
public class Test8 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), R = readInt(), rab[]=new int[N+1], pre[]=new int[N+1];
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<Integer>();
		for(int i=1; i<N; i++){
			int u = readInt(), v = readInt();
			adj[u].add(v); adj[v].add(u);
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean vis[] = new boolean[N+1];
		for(int i=1; i<=R; i++){
			int r = readInt(); Q.add(r); vis[r]=true;
		}
		while(!Q.isEmpty()){   //1st BFS start from all the rabbits
			int u = Q.poll();
			for(int v: adj[u])
				if(!vis[v]) { Q.add(v); rab[v] = rab[u]+1; vis[v]=true;}
		}
		int x = readInt(), y = readInt();  Q.add(x); pre[x]=-1;
		while(!Q.isEmpty()){   //2nd BFS start from x
			int u = Q.poll();
			for(int v: adj[u])
				if(pre[v] == 0){ Q.add(v); pre[v] = u; }
		}
		int ans = N+1;
		for(int v=y; v!=-1; v=pre[v]) ans = Math.min(ans, rab[v]);
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
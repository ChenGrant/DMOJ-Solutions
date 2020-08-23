import java.io.*;
import java.util.*;

public class Pursuit_of_Knowledge {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt(), T = readInt();
		List<Integer> adj[]= new ArrayList[N+1];
		for (int i =1; i<=N; i++){
			adj[i]= new ArrayList();
		}
		for (int i =1; i<=M; i++) {
			adj[readInt()].add(readInt());
		}
		int dis[][]= new int [N+1][N+1];
		boolean vis [][]= new boolean [N+1][N+1];
		for (int i =1; i<=N; i++) {
			Queue<Integer>Q= new LinkedList();
			Q.add(i);
			dis[i][i]=0;
			vis [i][i]= true;
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				for (int nxt: adj[cur]) {
					if (!vis[i][nxt]) {
						vis[i][nxt]= true;
						Q.add(nxt);
						dis[i][nxt]= dis[i][cur]+1;
					}
				}
			}
		}
		int query = readInt();
		for (int i =1; i<=query; i++) {
			int a = readInt(), b = readInt();
			if (vis[a][b])
				System.out.println(dis[a][b]*T);
			else
				System.out.println("Not enough hallways!");
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
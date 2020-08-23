import java.util.*;
import java.io.*;
public class Test3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), h = readInt(), g[][] = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				g[i][j] = readInt();
		Queue<Integer> qr = new LinkedList<Integer>(), qc = new LinkedList<Integer>();
		boolean vis[][] = new boolean[n][n];
		int d[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		qr.add(0); qc.add(0); vis[0][0] = true;
		while(!qr.isEmpty()){
			int r = qr.poll(), c = qc.poll();
			for(int i=0; i<4; i++){
				int nr = r+d[i][0], nc = c+d[i][1];
				if(nr>=0&&nr<n &&nc>=0 && nc<n && !vis[nr][nc] && Math.abs(g[nr][nc]-g[r][c])<=h){
					qr.add(nr); qc.add(nc); vis[nr][nc] = true;
				}
			}	
		}
		System.out.println(vis[n-1][n-1]? "yes":"no");
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
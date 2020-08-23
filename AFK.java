import java.io.*;
import java.util.*;


public class AFK {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = readInt(); 
		int dir [][]= {{-1,0},{1,0},{0,-1},{0,1}};
		for (int t = 1; t<=T; t++) {
			int C = readInt();
			int R = readInt();
			char g[][]= new char [R][C];
			int sr = 0, sc = 0, er = 0,ec = 0;
			for (int i =0; i<R; i++) {
				g[i]= readLine().toCharArray();
				for (int j =0; j<C; j++) {
					if (g[i][j]=='C') {
						sr= i ;
						sc = j;
					}
					if (g[i][j]=='W') {
						er = i ;
						ec = j;
					}
				}
			}
			Queue <Integer>qr = new LinkedList(), qc = new LinkedList();
			boolean vis[][]= new boolean [R][C];
			int dis[][]= new int[R][C];
			qr.add(sr);
			qc.add(sc);
			vis[sr][sc]= true;
			dis[sr][sc]= 0 ;
			while(!qr.isEmpty()) {
				int r = qr.poll(), c = qc.poll();
				for (int d =0; d<4; d++) {
					int nr  = r +dir[d][0], nc = c+dir[d][1];
					if (nr >=0 && nr<R && nc >=0 && nc <C && !vis[nr][nc]&& g[nr][nc]!='X') {
						qr.add(nr); qc.add(nc); vis [nr][nc]= true;
						dis[nr][nc]=  dis[r][c]+1;
					}
				}
			}
			if (vis[er][ec]&& dis[er][ec]<60)
				System.out.println(dis[er][ec]);
			else
				System.out.println("#notworth");
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

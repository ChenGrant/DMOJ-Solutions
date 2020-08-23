import java.util.*;
import java.io.*;
public class Test1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for(int t=1; t<=T; t++) {
			int N = readInt(); String s[] = new String[N];
			for(int i=0; i<N; i++) s[i] = readLine();
			HashMap<String, Integer> map = new HashMap();
			map.put(s[N-1], 0); int cur = 0, dep = 0;
			for(int i=0; i<N; i++) {
				if(!map.containsKey(s[i])) {
					cur++; map.put(s[i], cur);
					dep = Math.max(dep, cur);
				}else cur = map.get(s[i]);
			}
			System.out.println(N*10 - dep*20);
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
import java.util.*;
import java.io.*;
public class Test4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int B = readInt(), ans = 0, st[]=new int[B], ed[]=new int[B], pt[] = new int[B];
		for(int i=0; i<B; i++){
			st[i] = readInt(); ed[i] = readInt(); pt[i]=readInt();
		}
		int F = readInt(), x[] = new int[F];
		for(int i=0; i<F; i++) x[i] = readInt();
		Arrays.sort(x);
		for(int i=0; i<B; i++){
			int pos = Arrays.binarySearch(x, st[i]);
			if(pos < 0) pos = - pos - 1;
			if(pos == F || x[pos] > ed[i]) ans += pt[i];
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
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
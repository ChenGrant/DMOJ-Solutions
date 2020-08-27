import java.util.*;
import java.io.*;
public class Test11 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int K = readInt(), last = 0, e[][] = new int[5000][2], cnt=0;
		for(int n=5000; n>1; n--){
			while(n*(n-1)/2 <= K){
				int st = last+1, ed = last+n;
				if(last != 0) { e[cnt][0]=last; e[cnt][1]=st; cnt++; }
				for(int i=st; i<ed; i++){
					e[cnt][0]=i; e[cnt][1]=i+1; cnt++;
				}
				e[cnt][0]=ed; e[cnt][1]=st; cnt++;
				K -= n*(n-1)/2; last = ed;
			}
		}
		System.out.println(last + " " + cnt);
		for(int i=0; i<cnt; i++)
			System.out.println(e[i][0] + " " +e[i][1]);
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
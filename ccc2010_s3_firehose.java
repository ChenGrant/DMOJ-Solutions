import java.util.*;
import java.io.*;
public class ccc2010_s3_firehose {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int H, house[], LEN=1000000;
	public static void main(String[] args) throws IOException {
		H = readInt(); house = new int[H];
		for(int i=0; i<H; i++) house[i] = readInt();
		Arrays.sort(house);
		int K = readInt(), lo = 0, hi = LEN, ans = 0;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(check(mid) <= K){ ans = mid; hi = mid-1;}
			else lo = mid+1;
		}
		System.out.println(ans);
	}
	public static int check(int r){
		int ret = H, d = 2*r;
		for(int st=0; st<house.length && house[st] <= house[0] + d; st++){
			int cnt = 1;
			for(int nxt = st+1, lst=house[st]; nxt < house.length && house[nxt] + d - LEN < house[st]; nxt++){
				if(house[nxt] > lst){ lst = house[nxt] + d; cnt++; }
			}
			ret = Math.min(ret, cnt);
		}
		return ret;
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
import java.util.*;
import java.io.*;

public class Nightmareathon {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		int q = readInt();
		int rating[] = new int[n+1];
		int maxL[] = new int[n+1];
		int maxR[] = new int [n+1];
		int freqL[] = new int[n+1];
		int freqR[] = new int [n+1];
		for (int i =1; i<=n;i++) {
			rating[i] = readInt();
		}
		maxL[1] = rating[1];
		for (int i =2; i<=n; i++) {
			maxL[i] = Math.max(rating[i], maxL[i-1]);
		}
		maxR[n] = rating[n];
		for (int i = n-1; i>=1; i--) {
			maxR[i] = Math.max(rating[i], maxR[i+1]);
		}
		freqL[0]=0;
		for (int i =1; i<=n; i++) {
			if (maxL[i]==rating[i] && maxL[i]!=maxL[i-1]) {
				freqL[i] = 1;
			}
			else if (maxL[i]==rating[i]) {
				freqL[i]= freqL[i-1]+1;
			}
			else {
				freqL[i]=freqL[i-1];
			}
		}
		freqR[n]=1;
		for (int i =n-1; i>=1; i--) {
			if (maxR[i]==rating[i] && maxR[i]!=maxR[i+1]) {
				freqR[i] = 1;
			}
			else if (maxR[i]==rating[i]) {
				freqR[i]= freqR[i+1]+1;
			}
			else {
				freqR[i]=freqR[i+1];
			}
		}
		/*
		for (int i =1; i<=n; i++) {
			System.out.print(freqL[i]+" ");
				
		}
		System.out.println();
		for (int i =1; i<=n; i++) {
			System.out.print(freqR[i]+" ");
				
		}*/
		for (int  f =0; f<q; f++) {
			int a = readInt();
			int b = readInt();
			int left = 0;
			if (a==1 && b== n) {
				System.out.println("0 0");
				continue;
			}
			else if (a==1 && b!=n) {
				System.out.println(maxR[b+1]+" "+freqR[b+1]);
				continue;
			}
			else if (a!=1 && b==n) {
				System.out.println(maxL[a-1]+" "+freqL[a-1]);
				continue;
			}
			System.out.print(Math.max(maxL[a-1], maxR[b+1])+" ");
			if (maxL[a-1]>maxR[b+1]) {
				System.out.println(freqL[a-1]);
				
			}
			else if (maxL[a-1]<maxR[b+1]) {
				System.out.println(freqR[b+1]);
			}
			else
				System.out.println(freqL[a-1]+freqR[b+1]);
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

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
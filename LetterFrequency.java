import java.util.*;
import java.io.*;

public class LetterFrequency {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		String s = readLine();
		int q = readInt();
		int l = s.length();
		//System.out.println(l);
		int n[][] = new int[27][l + 1];
		for (int i = 1; i <= 26; i++) {
			for (int z = 1; z <= l; z++) {
				if (s.charAt(z-1) - 96 == i) {
					n[i][z] = 1+n[i][z - 1];
				}
				else
					n[i][z]= n[i][z - 1];
			}
		}
		/*
		for (int i = 1; i <= 26; i++) {
			System.out.println((char)(i+96));
			for (int z = 1; z <= l; z++) {
				System.out.print(n[i][z] +" ");
			}
			System.out.println();
		}*/
		for (int f =0; f<q;f++ ) {
			int a = readInt();
			int b = readInt();
			char c = readCharacter();
			int c1 = c-96;
			System.out.println(n[c1][b]-n[c1][a-1]);
			
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
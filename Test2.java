import java.util.*;
import java.io.*;
public class Test2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int R = 10, C = 9; String cell[][] = new String[R][C];
		int val[][] = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				cell[i][j] = next(); val[i][j] = -1;
				if(cell[i][j].charAt(0) <= '9') val[i][j] = Integer.parseInt(cell[i][j]);
			}
		}
		while(true) {
			boolean flag = false;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(val[i][j] != -1) continue;
					val[i][j] = eval(i, j, cell[i][j], val);
					if(val[i][j] != -1) flag = true;
				}
			}
			if(!flag) break;
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++)
				if(val[i][j] == -1) System.out.print("* ");
				else System.out.print(val[i][j] + " ");
			System.out.println();
		}
	}
	static int eval(int r, int c, String expr, int [][] val) {
		int sum = 0;
		for(int i=0; i<expr.length(); i+=3) {
			int row = expr.charAt(i)-'A', col = expr.charAt(i+1)-'1';
			if(val[row][col] == -1) return -1;
			sum += val[row][col];
		}
		return sum;
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
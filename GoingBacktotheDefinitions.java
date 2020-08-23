import java.util.*;
import java.io.*;
public class GoingBacktotheDefinitions {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	int n = readInt();
		String s[] = new String[n];
		for (int i=0; i<n; i++) {
			s[i] = readLine();
		}
		Arrays.sort(s, new cmp());
		//System.out.println(Arrays.toString(s));
		for (int i =0; i<n; i++) {
			System.out.print(s[i]);
		}
		
    }
    static class cmp implements Comparator<String>{
    	public int compare(String a, String b) {
    		String ab = a+b, ba = b+a;
    		return -ab.compareTo(ba);
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
import java.io.*;
import java.util.*;

public class DeathGun {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int M= readInt(), indeg[] = new int [2*M], N=0;
		Map <String, Integer> map = new HashMap();
		List <String> name = new ArrayList();
		List <Integer> adj[]= new ArrayList[2*M];
		for (int i =0; i <adj.length; i++) {
			adj[i]= new ArrayList();
		}

		for (int i =1; i<=M; i++) {
			String a = next(), b = next();
			if (!map.containsKey(a)) {
				map.put(a, N++);
				name.add(a);
			}
			if (!map.containsKey(b)) {
				map.put(b, N++);
				name.add(b);
			}
			adj[map.get(b)].add(map.get(a)); indeg[map.get(a)]++;
		}
		while (true) {
			int id =-1;
			for (int i =0; i<N; i++) {
				if (indeg[i]==0) {
					id = i;
					indeg[i]--;
					break;
				}
			}
			if (id ==-1)break;
			System.out.println(name.get(id));
			for (int v: adj[id])
				indeg [v]--;
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
import java.io.*;
import java.util.*;
public class Babbling_Brooks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		ArrayList <Double> streamFlow = new ArrayList<Double>();
		for (int i =0; i<n; i++) {
			double x = readInt();
			streamFlow.add(x);
		}
		int input = readInt();
		while (input!=77) {
			if (input ==99) {
				//System.out.println("hi");
				int index = readInt()-1;
				double percentageLeftFlow = readDouble()/100.0;
				double hold = streamFlow.get(index);
				//System.out.println(streamFlow.get(index)+"\t"+percentageLeftFlow);
				//System.out.println(streamFlow.get(index)*(percentageLeftFlow));
				streamFlow.set(index, streamFlow.get(index)*(percentageLeftFlow));
				streamFlow.add(index+1, hold*(1-percentageLeftFlow));
			}
			if (input ==88) {
				int index = readInt()-1;
				streamFlow.set(index, streamFlow.get(index)+streamFlow.get(index+1));
				streamFlow.remove(index+1);
			}

			//System.out.println(streamFlow);

			input = readInt();
		}
		for (int i = 0; i<streamFlow.size(); i++) {

			System.out.print(Math.round(streamFlow.get(i))+" ");
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
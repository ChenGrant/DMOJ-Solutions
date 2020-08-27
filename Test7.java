import java.util.*;
import java.io.*;
public class Test7 {
	static int N, M, len, root;
	static ArrayList<Integer> [] adj;
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N=Integer.parseInt(st.nextToken()); 
		adj = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			adj[i] = new ArrayList<Integer>();
		for(int i=1; i<N; i++){
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			adj[x].add(y); adj[y].add(x);
		}
		len = 0; BFS(1);
		len = 0; BFS(root);
		System.out.println(len);
	}
	public static void BFS(int st){
		boolean [] vis = new boolean [N+1];
		int [] dis = new int[N+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(st); vis[st] = true; dis[st] = 0;
		while(!Q.isEmpty()){
			int cur = Q.poll(); 
			if(dis[cur] > len){ len = dis[cur]; root = cur; }
			for(int v: adj[cur])
				if(!vis[v]) { Q.add(v); vis[v]=true; dis[v] = dis[cur]+1;}
		}
	}
}
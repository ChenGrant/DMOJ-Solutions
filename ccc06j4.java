import java.util.*;
public class ccc06j4 {
    static List<Integer> adj[] = new ArrayList[8];
    static int in[] = new int[8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < adj.length; i++)
            adj[i] = new ArrayList();
        int a[][] = {{1, 7}, {1, 4}, {2, 1}, {3, 4}, {3, 5}};
        for(int i = 00; i < a.length; i++) addEdge(a[i][0], a[i][1]);
        while(true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == 0) break;
            addEdge(x, y);
        }
        List<Integer> ans = new ArrayList();
        while(true) {
            boolean found = false;
            for(int i = 1; i <= 7; i++) {
                if(in[i] == 0) {
                    ans.add(i);
                    in[i]--;
                    found = true;
                    for(int j : adj[i]) in[j]--;
                    break;
                }
            }
            if(!found) break;
        }
        if(ans.size() != 7) System.out.println("Cannot complete these tasks. Going to bed.");
        else {
            for(int x : ans) System.out.print(x + " ");
        }
    }
    
    static void addEdge(int u, int v) {
        adj[u].add(v); in[v]++;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Prime_Factorization {
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	public static void main(String[]args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sieve();
		int n = Integer.parseInt(br.readLine());
		for(int i=1; i<=n; i++){
			int x = Integer.parseInt(br.readLine());
			int y = (int)Math.sqrt(x);
			for(int f: prime){
				if(f > y) break;
				while(x % f == 0) { 
					System.out.print(f+" ");
					x/=f; 
				}
			}
			if(x != 1) 
				System.out.println(x);
			else 
				System.out.println();
		}
	}
	public static void sieve(){
		int up = (int)Math.sqrt(1e7);
		boolean filter [] = new boolean[up+1];
		for(int i=2; i<=up; i++){
			if(!filter[i]){
				prime.add(i);
				for(int j=i*i; j<=up; j+=i) filter[j]=true;
			}
		}
	}
}
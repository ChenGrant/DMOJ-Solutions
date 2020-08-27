import java.util.Scanner;
public class Is_it_a_Tree {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int adj[][] = new int [4][4];
		boolean isTree = true;
		int sum =0;
		boolean notAllZero = true;
		for (int i =0; i< 4; i++) {
			int rowSum =0;
			for (int z =0; z<4; z++) {
				adj[i][z]= sc.nextInt();
				sum+=adj[i][z];
				rowSum+=adj[i][z];
			}
			if (rowSum==0)
				notAllZero = false;
		}
		if (sum!=6)
			isTree = false;
		
		if (isTree && notAllZero)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
import java.util.Scanner;
public class Bananas {
	public static void main(String[]args) {
		Scanner sc = new Scanner (System.in);
		String input = sc.nextLine();
		while(!input.equals("X")) {
			while(input.indexOf("ANA")!=-1 || input.indexOf("BAS")!=-1) {
				input = input.replaceAll("ANA|BAS", "A");
			}
			if (input.equals("A"))
				System.out.println("YES");
			else
				System.out.println("NO");
			input= sc.nextLine();
		}
	}
}
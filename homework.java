import java.util.*;
public class homework {
	static String base = "Good writing is good writing is good writing.";
	static String pre = "Good writing is good ", mid = " writing is good ", suf = " is good writing.";
	static long len [] = new long [31];
	public static void main (String [] args){
		Scanner in = new Scanner(System.in);
		len[0] = base.length();
		for(int i=1; i<len.length; i++)
			len[i] = pre.length() + len[i-1] + mid.length() + len[i-1] + suf.length();
		int Q = in.nextInt();
		for(int i=1; i<=Q; i++) {
			int lvl = in.nextInt(), k = in.nextInt()-1;
			if(k >= len[lvl]) System.out.println(".");
			else fun(lvl, k);
		}
	}
	static void fun(int lvl, int k) {
		if(lvl == 0) { System.out.println(base.charAt(k)); return; }
		if(k < pre.length()) { System.out.println(pre.charAt(k)); return; }
		k -= pre.length();
		if(k < len[lvl-1]) { fun(lvl-1, k); return; }
		k -= len[lvl-1];
		if(k < mid.length())  { System.out.println(mid.charAt(k)); return; }
		k -= mid.length(); 
		if(k < len[lvl-1]) { fun(lvl-1, k); return; }
		k -= len[lvl-1];
		System.out.println(suf.charAt(k)); 
	}
}
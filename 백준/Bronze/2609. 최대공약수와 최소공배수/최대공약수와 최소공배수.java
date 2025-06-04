import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = gcd(a,b);
		int lcm = a*b / gcd;
		
		System.out.println(gcd+"\n"+lcm);
	}
	
	public static int gcd(int a, int b) {
		while(b!=0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
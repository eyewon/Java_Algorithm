import java.io.*;
import java.util.*;

class Main {

	public static long pow(long a, long b, long c) {
		if(b == 0) return 1;
		if(b%2==0) return pow(a*a % c, b/2, c);
		else return a * pow(a, b-1, c) % c;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		System.out.println(pow(A,B,C));
	}
}
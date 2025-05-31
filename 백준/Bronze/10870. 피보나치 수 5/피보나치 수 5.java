import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(pibonachi(N));
	}
	
	public static long pibonachi(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return pibonachi(n-2)+pibonachi(n-1);
	}
}
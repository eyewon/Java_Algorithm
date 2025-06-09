import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String st = br.readLine();
		long hash = 0;
		long r = 1;
		long M = 1234567891;
		for(int i=0; i<L; i++) {
			int a = st.charAt(i)-'a'+1;
			hash += (a*r);
			r = (31*r) % M;
		}
		System.out.println(hash % M);
 	}
}
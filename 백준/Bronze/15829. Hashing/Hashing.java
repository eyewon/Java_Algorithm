import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String st = br.readLine();
		int hash = 0;
		for(int i=0; i<st.length(); i++) {
			int a = st.charAt(i)-'a'+1;
			int r = (int)Math.pow(31, i);
			hash += (a*r) % 1234567891;
		}
		System.out.println(hash);
 	}
}
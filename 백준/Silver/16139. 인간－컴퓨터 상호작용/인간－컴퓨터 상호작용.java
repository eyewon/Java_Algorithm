import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int[][] psum = new int[26][input.length+1]; //1-based

		for(int i=1; i<input.length+1; i++) {
			char ch = input[i-1];
			for(int j=0; j<26; j++) {
				psum[j][i] = psum[j][i-1];
			}
			psum[ch-'a'][i] ++;
		}
		
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken()); //0-based
			int r = Integer.parseInt(st.nextToken());
			sb.append(psum[c-'a'][r+1] - psum[c-'a'][l]).append("\n");
		}
		
		System.out.println(sb);
 	}
}
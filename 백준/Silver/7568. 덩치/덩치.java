import java.io.*;
import java.util.*;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] person = new int[N][2];
		int[] rank = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			person[i][0] = Integer.parseInt(st.nextToken()); //x
			person[i][1] = Integer.parseInt(st.nextToken()); //y
		}
		
		for(int i=0; i<N; i++) {
			int k=0;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				if(person[j][0] > person[i][0] && person[j][1] > person[i][1]) {
					k++;
				}
			}
			rank[i] = k+1;
		}
		StringBuilder sb = new StringBuilder();
		for(int k: rank) {
			sb.append(k+" ");
		}
		System.out.println(sb);
	}
}
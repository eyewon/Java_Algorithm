import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = K;
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(sum/coin[i] > 0)
				cnt+= sum/coin[i];
			sum %= coin[i];
		}
		System.out.println(cnt);
 	}
}
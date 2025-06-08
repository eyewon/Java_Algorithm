import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] psum = new long[N+1];
		long[] modcnt = new long[M];
		st = new StringTokenizer(br.readLine());
		long cnt=0;
		
		for(int i=1; i<=N; i++) {
			psum[i] = psum[i-1] + Integer.parseInt(st.nextToken());
			int mod = (int) ((psum[i]%M+M)%M);
			if(mod==0) cnt++;
			modcnt[mod]++;
		}
		// psum[j]%M = psum[i-1]%M 인 조합
		for(int i=0; i<M; i++) {
			if(modcnt[i] > 1)
				cnt += modcnt[i]*(modcnt[i]-1)/2;
		}
		System.out.println(cnt);
 	}
}
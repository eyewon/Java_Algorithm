import java.io.*;
import java.util.*;

class Main {
	static int MOD = 1_000_000_007;
	
	public static long pow(long a, long b) {
		if(b==0) return 1;
		else if(b%2==0) return pow(a*a %MOD, b/2) % MOD;
		else return (a* pow(a, b-1)) % MOD;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] fac = new long[N+1];
		long[] infac = new long[N+1];
		
		//팩토리얼, 역팩토리얼 계산
		fac[0] = 1;
		for(int i=1; i<=N; i++) {
			fac[i] = (fac[i-1]*i) % MOD;
		}
		infac[N] = pow(fac[N], MOD-2);  //N!의 역원
		for(int i=N-1; i>=0; i--) {
			infac[i] = (infac[i+1]*(i+1)) %MOD;
		}
		
		long result = fac[N];
		result = (result * infac[K]) % MOD;
		result = (result * infac[N - K]) % MOD;
		System.out.println(result);
	}
}
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i*i <= N; i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		List<Integer> prime = new ArrayList<>();
		for(int i=2; i<=N; i++) {
			if(isPrime[i]) prime.add(i);
		}
		
		int start=0, end=0, sum=0, cnt =0;
		while(end < prime.size()) {
			sum += prime.get(end++);
			
			while(sum > N && start < end) {
				sum -= prime.get(start++);
			}
			
			if(sum == N) {
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
}
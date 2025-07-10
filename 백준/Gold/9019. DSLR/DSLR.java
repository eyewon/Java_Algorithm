import java.io.*;
import java.util.*;

class Main {
	static class Trans{
		int past;
		char oper;
		
		Trans(int past, char oper){
			this.past = past;
			this.oper = oper;
		}
	}
	
	public static Trans[] bfs(int[] count, int A) {
		Queue<Integer> queue = new LinkedList<>();
		Trans[] dslr = new Trans[count.length];
		
		queue.add(A);
		count[A] = 0;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			int d1 = n/1000;
			int d2 = (n/100) %10;
			int d3 = (n/10) %10;
			int d4 = n %10;
			
			int d = 2*n % 10000;
			int s = n==0? 9999: n-1;
			int l = d2*1000 + d3*100 + d4*10 + d1;
			int r = d4*1000 + d1*100 + d2*10 + d3;
			
			if(count[d] > count[n]+1) {
				queue.add(d);
				count[d] = count[n]+1;
				dslr[d] = new Trans(n, 'D');
			} 
			if(count[s] > count[n]+1) {
				queue.add(s);
				count[s] = count[n]+1;
				dslr[s] = new Trans(n, 'S');
			}
			if(count[l] > count[n]+1) {
				queue.add(l);
				count[l] = count[n]+1;
				dslr[l] = new Trans(n, 'L');
			}
			if(count[r] > count[n]+1) {
				queue.add(r);
				count[r] = count[n]+1;
				dslr[r] = new Trans(n, 'R');
			}
		}
		return dslr;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] count = new int[10_000];
		
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=0; test_case<T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Arrays.fill(count, Integer.MAX_VALUE);
			Trans[] dslr = bfs(count, A);
			
			int cnt = count[B];
			StringBuilder s = new StringBuilder();
 			for(int i=B; i!=A; i=dslr[i].past) {
				s.append(dslr[i].oper);
			}

			sb.append(s.reverse()).append("\n");
		}
		System.out.println(sb);
	}
}
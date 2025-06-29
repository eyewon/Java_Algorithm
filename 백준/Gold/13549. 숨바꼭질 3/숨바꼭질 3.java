import java.io.*;
import java.util.*;

class Main {
	
	public static void bfs(int[] distance, int N, int K) {
		Deque<Integer> dq = new ArrayDeque<>();
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[N] = 0;
		dq.addFirst(N);
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			
			for(int next : new int[] {cur+1, cur-1, cur*2 }) {
				if(next >=0 && next<distance.length) {
					// 0초짜리 순간이동 
					if(next==cur*2 && distance[next] > distance[cur]) {
						distance[next]=distance[cur];
						dq.addFirst(next); // 앞에 넣기 
						
					// 1초자리 걷기
					}else if(next != cur*2 && distance[next] > distance[cur]+1){
						distance[next]=distance[cur]+1;
						dq.addLast(next); // 뒤에 넣기 
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[100_001];
		
		bfs(distance, N, K);
		System.out.println(distance[K]);
	}
}
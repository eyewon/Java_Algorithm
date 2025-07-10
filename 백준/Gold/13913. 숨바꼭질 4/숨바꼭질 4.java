import java.io.*;
import java.util.*;

class Main {
	
	public static int[] bfs(int[] distance, int N, int K) {
		Queue<Integer> queue = new LinkedList<>();
		int[] past = new int[distance.length];
		
		queue.add(N);
		distance[N] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int next: new int[] {cur-1, cur+1, cur*2}) {
				if(next>=0 && next<=100_000 && distance[next] > distance[cur]+1) {
					queue.add(next);
					distance[next] = distance[cur]+1;
					past[next] = cur;
				}
			}
		}
		return past;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[100_001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		int[] past = bfs(distance, N, K);
		
		StringBuilder sb = new StringBuilder();
		sb.append(distance[K]).append("\n");
		
		List<Integer> list = new ArrayList<>();
		for(int i=K; i>=0; i=past[i]) {
			list.add(i);
			if(i==N) break;
		}
		Collections.reverse(list);
		for(int l: list) {
			sb.append(l).append(" ");
		}
		
		System.out.println(sb);
	}
}
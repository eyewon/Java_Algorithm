import java.io.*;
import java.util.*;

class Main {
	static final int MAX = 100_000;
	static int[] map;
	static boolean[] visited = new boolean[MAX+1];
	static int[] dist = new int[MAX+1];

	public static void bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(N);
		visited[N] = true;
		dist[N] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == K) {
				System.out.println(dist[K]);
				return;
			}
			for(int next: new int[] {cur+1, cur-1, cur*2}) {
				if(next>=0 && next<=MAX &&!visited[next]) {
					queue.add(next);
					visited[next] = true;
					dist[next] = dist[cur] + 1;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
	}
}
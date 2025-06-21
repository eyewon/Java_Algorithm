import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		//bfs
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		int cnt=0;
		
		visited[1] = true;
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int next: graph[node]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					cnt++;
				}
				
			}
		}
		
		System.out.println(cnt);
	}
}
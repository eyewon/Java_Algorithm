import java.io.*;
import java.util.*;

class Main {
	static int[] order;
	static int visitedOrder = 1;
	
	public static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int R) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(R);
		visited[R] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			order[node] = visitedOrder++;
			
			for(int next: graph[node]) {
				if(!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		order = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		bfs(graph, visited, R);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb);
	}
}
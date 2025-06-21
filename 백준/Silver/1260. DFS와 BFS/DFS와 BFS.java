import java.io.*;
import java.util.*;

class Main {
	
	public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int S) {
		visited[S] = true;
		System.out.print(S+" ");
		
		for(int next: graph[S]) {
			if(!visited[next]) {
				visited[next] = true;
				dfs(graph, visited, next);
			}
		}
	}
	
	public static void bfs(ArrayList<Integer>[] graph, boolean[] visited, int S) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(S);
		visited[S] = true;
		System.out.print(S+" ");
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int next: graph[node]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
					System.out.print(next+" ");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		
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
		
		boolean[] visited = new boolean[N+1];
		dfs(graph, visited, V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(graph, visited, V);
	}
}
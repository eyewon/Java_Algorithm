import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	
	public static void dfs(List<Integer>[] graph, boolean[] visited, int S) {
		visited[S] = true;
		
		for(int next: graph[S]) {
			if(!visited[next]) {
				dfs(graph, visited, next);
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		List<Integer>[] graph = new ArrayList[N+1];
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
		
		cnt = 0;
		dfs(graph, visited, 1);
		System.out.println(cnt);
		
	}
}

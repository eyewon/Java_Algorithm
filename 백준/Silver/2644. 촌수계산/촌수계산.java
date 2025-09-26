import java.io.*;
import java.util.*;

public class Main {
	static int[] dist;
	
	public static void bfs(List<Integer>[] graph, int S) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(S);
		dist[S] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next: graph[now]) {
				if(dist[next] == -1) {
					q.add(next);
					dist[next] = dist[now]+1;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer>[] graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		dist = new int[n+1];
		Arrays.fill(dist, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}
		
		bfs(graph, a);
		System.out.println(dist[b]);
	}
}

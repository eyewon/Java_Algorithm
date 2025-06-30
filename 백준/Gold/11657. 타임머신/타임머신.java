import java.io.*;
import java.util.*;

class Main {
	static final int INF = Integer.MAX_VALUE;
	
	static class Edge{
		int from, to, cost;
		
		Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static boolean bellmanFord(int start, List<Edge> edges, long[] dist) {
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		for(int i=0; i<dist.length-2; i++) {
			boolean updated = false;
			for(Edge e: edges) {
				if(dist[e.from]!=INF && (dist[e.to] > dist[e.from]+e.cost) ) {
					dist[e.to] = dist[e.from] + e.cost;
					updated = true;
				}
			}
			if(!updated) break;
		}
		
		for(Edge e: edges) {
			if(dist[e.from] != INF && (dist[e.to] > dist[e.from]+e.cost)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] dist = new long[N+1]; // 거리 배열
		List<Edge> edges = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(A, B, C));
		}
		
		StringBuilder sb = new StringBuilder();
		boolean bellman = bellmanFord(1, edges, dist);
		if(!bellman){
			System.out.println(-1);
			return;
		}
		for(int i=2; i<=N; i++) {
			if(dist[i] != INF) 
				sb.append(dist[i]).append("\n");
			else 
				sb.append(-1).append("\n");
		}
		System.out.println(sb);
	}
}
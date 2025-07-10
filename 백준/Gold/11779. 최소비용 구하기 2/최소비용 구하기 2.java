import java.io.*;
import java.util.*;

class Main {
	static List<Node>[] graph;
	static int[] dist;
	static int[] path;
	
	static class Node implements Comparable<Node>{
		int to, cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void dijkstra(int start) {
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.to] < now.cost) continue;
			
			for(Node next: graph[now.to]) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
					path[next.to] = now.to;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		dist = new int[N+1];
		path = new int[1001];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		
		List<Integer> visit = new ArrayList<>();
		for(int i=end; i!=start; i=path[i]) {
			visit.add(i);
		}
		visit.add(start);
		sb.append(visit.size()).append("\n");
		Collections.reverse(visit);
		for(int v: visit) {
			sb.append(v).append(" ");
		}
		
		System.out.println(sb);
	}
}
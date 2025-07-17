import java.io.*;
import java.util.*;

class Main {
	static class Edge implements Comparable<Edge>{
		int to, cost;
		
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o){
			return Integer.compare(this.cost, o.cost);
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge>[] graph = new ArrayList[V+1];
		for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
		boolean[] visited = new boolean[V+1]; 
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue();
		pq.offer(new Edge(1, 0));
		int mstWeight = 0, cnt = 0;
		
		while(!pq.isEmpty() && cnt < V) {
			Edge cur = pq.poll();
			if(visited[cur.to]) continue;
			
			visited[cur.to] = true;
			mstWeight += cur.cost;
			cnt++;
			
			for(Edge next: graph[cur.to]) {
				if(!visited[next.to]) pq.offer(next);
			}
		}
		
		System.out.println(mstWeight);
		
	}

}
import java.io.*;
import java.util.*;

class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		public int compareTo(Edge o){
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	public static int find(int[] parent, int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent, parent[x]);
	}
	
	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		
		if(rootA != rootB) parent[rootA] = rootB; 
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge> edges = new ArrayList<>();
		int[] parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] = i;
		 
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(a, b, c));
		}
		
		Collections.sort(edges);
		int mstWeight = 0, cnt = 0;
		
		for(Edge e: edges) {
			if(find(parent, e.from)!=find(parent, e.to)) {
				union(parent, e.from, e.to);
				mstWeight+=e.cost;
				cnt++;
			}
			
			if(cnt == V-1) break;
		}
		System.out.println(mstWeight);
		
	}

}
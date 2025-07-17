import java.io.*;
import java.util.*;

class Main {
	static class Point{
		int id;
		float x, y;
		
		Point(int id, float x, float y){
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge>{
		Point from, to;
		float cost;
		
		Edge(Point from, Point to){
			this.from = from;
			this.to = to;
			this.cost = (float)Math.sqrt(
				    Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2)
				); // ✅ 유클리디안 거리

		}
		
		@Override
		public int compareTo(Edge o) {
			return Float.compare(this.cost, o.cost);
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

		int n = Integer.parseInt(br.readLine());
		
		List<Edge> edges = new ArrayList<>();
		int[] parent = new int[n+1];
		for(int i=1; i<=n; i++) parent[i] = i;
		
		Point[] star = new Point[n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			star[i] = new Point(i, x, y);
		}
		
		for(int i=1; i<n; i++) {
			for(int j=i+1; j<=n; j++) {
				edges.add(new Edge(star[i], star[j]));
			}
		}
		
		Collections.sort(edges);
		float mstWeight = 0;
		int cnt = 0;
		
		for(Edge e: edges) {
			if(find(parent, e.to.id) != find(parent, e.from.id)) {
				union(parent, e.to.id, e.from.id);
				cnt++;
				mstWeight+= e.cost;
			}
			
			if(cnt == n-1) break;
		}
		System.out.printf("%.2f",mstWeight);
	
	}
}
import java.io.*;
import java.util.*;

class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		Edge(int from, int to, int dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static int find(int[] parent, int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	
	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		if(rootA != rootB) parent[rootA] = rootB;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		while(!(input=br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[] parent = new int[m+1];
			for(int i=1; i<=m; i++) parent[i] = i;
			
			int totalWeight = 0; //총 비용
			List<Edge> edges = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				edges.add(new Edge(x, y, z));
				totalWeight+=z;
			}
			
			// MST 구하기
			Collections.sort(edges);
			
			int cnt=0, mstWeight=0;
			for(Edge e: edges) {
				if(find(parent, e.from)!= find(parent, e.to)) {
					cnt++;
					union(parent, e.from, e.to);
					mstWeight += e.dist;
				}
				if(cnt == m-1) break;
			}
			sb.append(totalWeight-mstWeight).append("\n");
		}
		System.out.println(sb);
	}
}
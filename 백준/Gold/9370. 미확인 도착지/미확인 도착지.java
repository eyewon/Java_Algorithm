import java.io.*;
import java.util.*;

class Main {
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	
	public static int[] dijkstra(List<Node>[] graph, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[graph.length];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.to] < now.cost) continue;
			
			for(Node next: graph[now.to]) {
				if(dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=0; test_case<T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //교차로 개수(=노드 개수)
			int m = Integer.parseInt(st.nextToken()); //도로 개수(=간선 개수)
			int t = Integer.parseInt(st.nextToken()); //목적지 후보의 개수
			
			List<Node>[] graph = new ArrayList[n+1]; //그래프
			for(int i=1; i<=n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken()); //예술가들의 출발지
			int g = Integer.parseInt(st.nextToken()); //예술가들이 지나간 도로의 한쪽 교차로
			int h = Integer.parseInt(st.nextToken()); //예술가들이 지나간 도로의 다른쪽 교차로
			
			int ghCost=0; // g-h의 가중치
			
			for(int i=0; i<m; i++) { // 간선 입력 (a와 b사이, 가중치 d)
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				graph[a].add(new Node(b, d));
				graph[b].add(new Node(a, d));
				
				if((a==g && b==h) || (a==h && b==g)) {
					ghCost=d;
				}
			}
			int[] fromS = dijkstra(graph, s); // s를 시작점으로 하는 다익스트라 거리배열
			int[] fromG = dijkstra(graph, g); // g를 시작점으로 하는 다익스트라 거리배열
			int[] fromH = dijkstra(graph, h); // h를 시작점으로 하는 다익스트라 거리배열 
 			
			List<Integer> solution = new ArrayList<>();
			
			for(int i=0; i<t; i++) { // 목적지 후보 입력 
				int x = Integer.parseInt(br.readLine()); 
				int route1 = fromS[g] + fromH[x] + ghCost; //s -> g-h -> x
				int route2 = fromS[h] + fromG[x] + ghCost; //s -> h-g -> x
				if(fromS[x] == route1 || fromS[x] == route2) {
					solution.add(x);
				}
				
			}
			Collections.sort(solution);
			
			for(int sol: solution) {
				sb.append(sol).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

class Main {
	static List<Node>[] tree;
	static boolean[] visited;
	static long maxDist;
	static int farthestNode = 0;
	
	static class Node{
		int to;
		int cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void dfs(int node, long dist) {
		visited[node] = true;
		
		if(dist > maxDist) {
			maxDist = dist;
			farthestNode = node;
		}
		
		for(Node next: tree[node]) {
			if(!visited[next.to]) {
				dfs(next.to, dist+ next.cost);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[V+1];
		
		for(int i=1; i<=V; i++) tree[i] = new ArrayList<>();
		
		for(int i=1; i<=V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to==-1) break;
				int cost = Integer.parseInt(st.nextToken());
				tree[from].add(new Node(to, cost));
			}
		}
		
		visited = new boolean[V+1];
		maxDist = 0;
		dfs(1, 0); //아무노드에서 시작해서 가장 먼 노드 찾기
		int A = farthestNode;
		
		visited = new boolean[V+1];
		maxDist = 0;
		dfs(A, 0); //A에서 가장 먼 노드 B 찾기 -> 이거리 = 트리의 지름
		
		System.out.println(maxDist);
	}

}
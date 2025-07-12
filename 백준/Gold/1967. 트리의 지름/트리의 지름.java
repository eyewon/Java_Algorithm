import java.io.*;
import java.util.*;

class Main {
	static List<Node>[] tree;
	static int[] dist;
	static boolean[] visited;

	static class Node{
		int to, cost;
		
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static int bfs(int node) {
		Queue<Node> queue = new ArrayDeque<>();
		
		Arrays.fill(visited, false);
		Arrays.fill(dist, 0);
		
		int farthestNode = node;
		
		dist[node] = 0;
		visited[node] = true;
		queue.add(new Node(node, 0));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for(Node next: tree[cur.to]) {
				if(!visited[next.to]) {
					visited[next.to] = true;
					dist[next.to] = dist[cur.to] + next.cost;
					queue.add(new Node(next.to, dist[next.to]));
					if(dist[next.to] > dist[farthestNode]) {
						farthestNode = next.to;
					}
				}
			}
		}
		
		return farthestNode;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			tree[parent].add(new Node(child, cost));
			tree[child].add(new Node(parent, cost));
		}
		
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		int A = bfs(1);
		int B = bfs(A);
		System.out.println(dist[B]);
	}

}
import java.io.*;
import java.util.*;

class Main {
	static ArrayList<Integer>[] graph;
	static int[] color;
	static boolean isBipartie;
	
	public static void bfs(int s, int c) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(s);
		color[s] = c;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			Collections.sort(graph[node]);
			
			for(int next: graph[node]) {
				if(color[next]==color[node]) {
					isBipartie=false;
					return;
				}
				if(color[next]==0) {
					color[next] = color[node]*(-1);
					queue.add(next);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			color = new int[V+1];
			
			for(int g=1; g<=V; g++) {
				graph[g] = new ArrayList<>();
			}
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			
			isBipartie = true;
			for(int s=1; s<=V; s++) {
				if(color[s]==0)
					bfs(s,1);
			}
			System.out.println(isBipartie?"YES":"NO");
			
		}
	}
}
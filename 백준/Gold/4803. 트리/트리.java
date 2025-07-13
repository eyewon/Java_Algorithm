import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static boolean isTree;
	
	public static void dfs(int node, int parent) {
		visited[node] = true;
		
		for(int next: graph[node]) {
			if(!visited[next]) {
				dfs(next, node);
			} else if (next != parent) {//이미 방문했는데 이전정점(parent)가 아닌경우는 사이클!
				isTree = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = 0;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0) break;
			test_case++;
			
			graph = new ArrayList[n+1];
			for(int i=1; i<=n; i++) graph[i] = new ArrayList<>();
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			visited = new boolean[n+1];
			int treeCount = 0;
			
			for(int i=1; i<=n; i++) {
				if(!visited[i]) {
					isTree = true;
					dfs(i, -1);
					if(isTree) treeCount++;
				}
			}
			
			sb.append("Case ").append(test_case).append(": ");
			if(treeCount==0) sb.append("No trees.");
			else sb.append(treeCount==1?"There is one tree.":"A forest of "+treeCount+" trees.");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
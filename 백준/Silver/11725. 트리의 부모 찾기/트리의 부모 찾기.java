import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] tree;
	static int[] parent;
	
	public static void dfs(int node, int par) {
		parent[node] = par;
		
		for(int next: tree[node]) {
			if(next != par) {
				dfs(next, node);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		parent = new int[N+1];
		
		for(int i=1; i<=N; i++) tree[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1,1);
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(parent[i]).append("\n");
		}
		System.out.println(sb);
	}

}
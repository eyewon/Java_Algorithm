import java.io.*;
import java.util.*;

class Main {

	public static int find(int[] parent, int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent, parent[x]);
	}
	
	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		
		if(rootA != rootB) {
			if(rootA > rootB) parent[rootA] = rootB;
			else parent[rootB] = rootA;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[n]; //선 플레이어

		for(int i=0; i<n; i++) {
			parent[i] = i; 
		}
		
		int stage = 0;
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(find(parent, u) == find(parent, v)) {
				stage = i;
				break;
			}else
				union(parent, u, v);
			
		}
		System.out.println(stage);
	}

}
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
		if(rootA != rootB) parent[rootA] = rootB;
	}
	
	public static boolean isUnion(int[] parent, int a, int b) {
		return find(parent, a) == find(parent, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(oper==0) {
				union(parent, a, b);
			}else {
				sb.append(isUnion(parent, a, b)?"YES":"NO").append("\n");
			}
		}
		
		System.out.println(sb);
	}

}
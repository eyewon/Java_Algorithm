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

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] parent = new int[N+1];
		int[] route = new int[M];
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int link = Integer.parseInt(st.nextToken());
				if(link==1) {
					union(parent, i, j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		int root = find(parent, route[0]);
		for(int i=1; i<M; i++) {
			if(find(parent, route[i]) != root) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

}
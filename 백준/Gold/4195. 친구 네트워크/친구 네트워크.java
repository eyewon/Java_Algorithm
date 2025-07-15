import java.io.*;
import java.util.*;

class Main {
	static Map<String, Integer> map;
	static int[] parent;
	static int[] size;
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootA] = rootB;
			size[rootB] += size[rootA];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 0; test_case < T; test_case++) {
			int F = Integer.parseInt(br.readLine());
			
			parent = new int[200_000];			
			size = new int[200_000];
			map = new HashMap<>();
			int idx = 0;
			
			for(int i=0; i<F; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String A = st.nextToken();
				String B = st.nextToken();
				
				if(!map.containsKey(A)) {
					map.put(A, idx);
					parent[idx] = idx;
					size[idx] = 1;
					idx++;
				}
				
				if(!map.containsKey(B)) {
					map.put(B, idx);
					parent[idx] = idx;
					size[idx] = 1;
					idx++;
				}
				
				int a = map.get(A);
				int b = map.get(B);
				
				union(a, b);
				sb.append(size[find(a)]).append("\n");
			}
		}
		System.out.println(sb);
	}

}
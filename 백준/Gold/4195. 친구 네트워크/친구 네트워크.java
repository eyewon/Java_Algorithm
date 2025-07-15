import java.io.*;
import java.util.*;

class Main {
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
		Map<String, Integer> nameIdx;
		
		
		for(int test_case = 0; test_case < T; test_case++) {
			int F = Integer.parseInt(br.readLine());
			
			parent = new int[200_000];			
			size = new int[200_000];
			
			nameIdx = new HashMap<>();
			int idx = 0;
			
			for(int i=0; i<F; i++) {
				String[] input = br.readLine().split(" ");
				
				if(!nameIdx.containsKey(input[0])) {
					nameIdx.put(input[0], idx);
					parent[idx] = idx;
					size[idx] = 1;
					idx++;
				}
				
				if(!nameIdx.containsKey(input[1])) {
					nameIdx.put(input[1], idx);
					parent[idx] = idx;
					size[idx] = 1;
					idx++;
				}
				
				union(nameIdx.get(input[0]), nameIdx.get(input[1]));
				System.out.println(size[find(nameIdx.get(input[0]))]);
			}
			
		}
	}

}
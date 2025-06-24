import java.io.*;
import java.util.*;

class Main {
	
	public static List<Integer> TopologicalSort(List<List<Integer>> graph, int[] inDegree){
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i]==0)
				queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);
			
			for(int neighbor: graph.get(node-1)) {
				inDegree[neighbor]--;
				
				if(inDegree[neighbor] == 0)
					queue.add(neighbor);
			}
			
		}
		
		return result;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		int[] inDegree = new int[N+1];
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A-1).add(B);
			inDegree[B]++;
		}
		
		List<Integer> result = TopologicalSort(graph, inDegree);
		
		if(result.size()!=N) {
			System.out.println("오류");
			System.exit(0);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : result) {
			sb.append(n+" ");
		}
		System.out.println(sb);
	}
}
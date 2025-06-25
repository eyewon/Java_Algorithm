import java.io.*;
import java.util.*;

class Main {
	
	public static void topologicalSort(List<List<Integer>> graph, int[] inDegree) {
		List<Integer> result = new ArrayList<>();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=1; i<graph.size(); i++) {
			if(inDegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			result.add(now);
			
			for(int next: graph.get(now)) {
				if(--inDegree[next] == 0)
					pq.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int v: result) {
			sb.append(v).append(" ");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		int[] inDegree = new int[N+1];
		
		graph.add(new ArrayList<>()); // 1-based
		for(int i=1; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph.get(A).add(B);
			inDegree[B]++;
		}
		
		topologicalSort(graph, inDegree);
	}
}
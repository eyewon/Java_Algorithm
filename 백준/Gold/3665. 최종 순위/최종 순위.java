import java.io.*;
import java.util.*;

class Main {
	
	public static void topologicalSort(List<List<Integer>> graph, int[] inDegree){
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<inDegree.length; i++) {
			if(inDegree[i]==0)
				queue.add(i);
		}
		
		
		while(!queue.isEmpty()) {
			
			if(queue.size()>1) {
				System.out.println("?");
				return;
			}
			
			int node = queue.poll();
			result.add(node);
			
			for(int neighbor: graph.get(node)) {
				inDegree[neighbor]--;
				
				if(inDegree[neighbor] == 0)
					queue.add(neighbor);
			}
			
		}
		
		if(result.size()!=graph.size()-1) {
			System.out.println("IMPOSSIBLE");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n: result) {
			sb.append(n+" ");
		}
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int k=0; k<K; k++) {
			int n = Integer.parseInt(br.readLine());
			List<List<Integer>> graph = new ArrayList<>();
			graph.add(new ArrayList<>()); // 1-based 
			int[] inDegree = new int[n+1];
			int[] preRank = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<n; i++) {
				preRank[i] = Integer.parseInt(st.nextToken());
				graph.add(new ArrayList<Integer>());
			}
			
			for(int a=0; a<n-1; a++) {
				for(int b=a+1; b<n; b++) {
					graph.get(preRank[a]).add(preRank[b]);
					inDegree[preRank[b]]++;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(graph.get(a).contains(b)) { //원래 a->b 였다면 b->a로 바꿔주기
					graph.get(b).add(a);
					graph.get(a).remove((Integer)b);
					inDegree[a]++;
					inDegree[b]--;
				} else {					  //원래 b->a 였다면 a->b로 바꿔주기 
					graph.get(a).add(b);
					graph.get(b).remove((Integer)a);
					inDegree[b]++;
					inDegree[a]--;
				}
			}
			
			topologicalSort(graph, inDegree);
		}
	
	}
}
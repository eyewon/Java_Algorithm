import java.io.*;
import java.util.*;

class Main {
	static int INF = Integer.MAX_VALUE;
	
	//경로복원 함수
	public static void recurPath(int[][] via, List<Integer> route, int i, int j) {
		if(via[i][j] == 0) {
			route.add(j);
		}else {
			recurPath(via, route, i, via[i][j]);
			recurPath(via, route, via[i][j], j);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		long[][] dist = new long[N+1][N+1];
		int[][] via = new int[N+1][N+1]; // i에서 j로 가는 최단경로 중 경유해야 할 중간 노드 저장 
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		//간선정보 저장 
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		//플로이드 워셜
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(dist[i][k]!=INF && dist[k][j] !=INF && dist[i][j] > dist[i][k]+dist[k][j]) {
						dist[i][j] = dist[i][k]+dist[k][j];
						via[i][j] = k;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 최소 비용 출력 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(dist[i][j]==INF)
					sb.append(0).append(" ");
				else
					sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		// 경로 복원 출력
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(dist[i][j]==INF || i==j) {
					sb.append(0).append("\n");
				}else {
					List<Integer> route = new ArrayList<>();
					route.add(i);
					recurPath(via, route, i, j);
					sb.append(route.size()).append(" ");
					for(int r: route) {
						sb.append(r).append(" ");
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
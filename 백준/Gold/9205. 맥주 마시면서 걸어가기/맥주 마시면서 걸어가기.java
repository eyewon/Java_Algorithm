import java.io.*;
import java.util.*;

public class Main {
	static int[][] nodes;
	static int n;
	static boolean[] visited;
	static int sx, sy; //집 좌표
	static int dx, dy; //도착지 좌표
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(nodes[0]);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x1 = now[0];
			int y1 = now[1];
			if(x1 == nodes[n+1][0] && y1 == nodes[n+1][1]) {
				System.out.println("happy");
				return;
			}
			
			for(int i=1; i<n+2; i++) {
				int x2 = nodes[i][0];
				int y2 = nodes[i][1];
				
				if(distance(x1, y1, x2, y2) <=1000 && !visited[i]) {
					q.add(new int[] {x2, y2});
					visited[i]=true;
				}
			}
		}
		System.out.println("sad");
	}
	
	public static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int test_case=0; test_case<t; test_case++) {
			n = Integer.parseInt(br.readLine()); //편의점 개수
			
			nodes = new int[n+2][2];
			visited = new boolean[n+2];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			nodes[0][0] = Integer.parseInt(st.nextToken());
			nodes[0][1] = Integer.parseInt(st.nextToken());
			
			for(int i=1; i<=n; i++) { //편의점
				st= new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodes[i][0] = x;
				nodes[i][1] = y;
			}
			
			st = new StringTokenizer(br.readLine());
			nodes[n+1][0] = Integer.parseInt(st.nextToken());
			nodes[n+1][1] = Integer.parseInt(st.nextToken());
			
			bfs();
		}
	}
}

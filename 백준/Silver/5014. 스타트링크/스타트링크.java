import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int[] dist;
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next: new int[] {now+U, now-D}) {
				if(next>=1 && next<=F && dist[next]==-1) {
					dist[next] = dist[now] + 1;
					q.add(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); 
		S = Integer.parseInt(st.nextToken()); 
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dist = new int[F+1];
		Arrays.fill(dist, -1);
		bfs(S);
		System.out.println(dist[G]==-1?"use the stairs":dist[G]);
	}
}

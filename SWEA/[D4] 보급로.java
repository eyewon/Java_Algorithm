// 문제: https://zrr.kr/P7zkd2
// 최단 경로 탐색 알고리즘 다익스트라(Dijkstra)


import java.util.*;

class Solution
{	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		
		Node(int x, int y, int cost){
			this.x=x;
			this.y=y;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int N;
	static int[][] map, dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스의 수
		
		for(int t=1; t<=T; t++) {
			N= sc.nextInt(); // 지도의 크기
			map=new int[N][N];
			dist=new int[N][N]; //출발지부터 해당 좌표까지의 최소 cost 값 
			for(int i=0; i<N; i++) { //지도 정보 업데이트
				String[] input = sc.next().split("");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(input[j]);
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			
			System.out.print("#"+t+" ");
			dijkstra();
			System.out.println(dist[N-1][N-1]);
		}
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0)); //시작점
		dist[0][0]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int cost = cur.cost;
			
			// 현재 경로가 이미 더 나은 경로보다 느리다면 무시
			if(cost > dist[x][y]) continue;
			
			// 상하좌우 네 방향으로 이동
			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(nx>=0 && ny>=0 && nx < N && ny < N) {
					int nCost = cost + map[nx][ny];
					// 더 적은 비용으로 이동 가능한 경우 갱신
					if(nCost < dist[nx][ny]) {
						dist[nx][ny]=nCost;
						pq.add(new Node(nx, ny, nCost));
					}
				}
			}
		}
		
		
	}
}

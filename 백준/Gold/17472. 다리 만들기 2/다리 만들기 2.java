import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[][] map;
	static int[][] landNum;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static class Edge implements Comparable<Edge>{
		int from, to, dist;
		
		Edge(int from, int to, int dist){
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		landNum = new int[N][M];
		visited = new boolean[N][M];
		
		//map 정보 입력
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 섬 식별하기 (번호 부여하기) 
		int num = 1; //섬 번호 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j] && map[i][j] == 1) bfs(i, j, num++);
			}
		}
		num--; //(=섬의 개수)
		
		//2. 다리 후보 구하기 (간선 리스트 만들기)
		List<Edge> edges = createEdgeList();
		
		//3. MST 모델링: 섬 번호-> 정점, 다리 후보-> 간선
		int[] parent = new int[num+1];
		for(int i=1; i<=num; i++) parent[i] = i;
		
		//4. MST 구하기: 크루스칼
		Collections.sort(edges);
		
		int cnt = 0, mstWeight = 0;
		for(Edge e: edges) {
			if(find(parent, e.to) != find(parent, e.from)) {
				union(parent, e.from, e.to);
				mstWeight += e.dist;
				cnt++;
			}
			
			if(cnt == num-1) break;
		}
		
		//5. MST 불가능 판단 & 정답 출력
		if(cnt != num-1) System.out.println(-1);
		else System.out.println(mstWeight);
	}
	
	
	// 섬 식별을 위한 bfs 함수
	public static void bfs(int x, int y, int num) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		landNum[x][y] = num;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx>=0 && nx < N && ny>=0 && ny < M && !visited[nx][ny]) {
					if(map[nx][ny]==1) {
						queue.add(new int[] {nx, ny});
						visited[nx][ny]= true;
						landNum[nx][ny]= num;
					}
				}
			}
		}
	}
	
	// 가능한 다리 후보로 이루어진 간선 리스트를 생성하는 함수
	public static List<Edge> createEdgeList(){
		List<Edge> edges = new ArrayList<>();
		Set<String> seen = new HashSet<>(); // 중복제거용
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(landNum[i][j] > 0) { // 육지라면
					int fromlandNum = landNum[i][j];
					
					for(int d=0; d<4; d++) {
						int nx = i;
						int ny = j;
						int dist = 0;
						
						while(true) {
							nx += dx[d];
							ny += dy[d];
							
							//범위 밖인 경우
							if(nx<0 || nx>=N || ny<0 || ny>=M) break;
							
							//같은 섬이면 중단
							if(landNum[nx][ny]==fromlandNum) break;
							
							//다른 섬 만나면 유효성 체크
							if(landNum[nx][ny]>0) {
								int tolandNum = landNum[nx][ny];
								if(dist >= 2) {
									int from = Math.min(fromlandNum, tolandNum);
									int to = Math.max(fromlandNum, tolandNum);
									String check = from+","+to+","+dist;
									
									if(!seen.contains(check)) { //중복 제거
										edges.add(new Edge(from, to, dist));
										seen.add(check);
									}
								}
								break;
							}
							
							//바다라면 계속 진행
							if(landNum[nx][ny]==0) dist++;
						}
					}
				}
			}
		}
		return edges;
	}
	
	//크루스칼 - find 함수
	public static int find(int[] parent, int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent, parent[x]);
	}
	
	//크루스칼 - union 함수
	public static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);
		if(rootA != rootB) parent[rootA] = rootB;
	}
}
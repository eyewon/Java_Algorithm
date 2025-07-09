import java.io.*;
import java.util.*;

class Main {
	static int N, W;
	static Point[] event;
	static int[][] dp; 
	static int[][] path;
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	//거리 계산
	public static int dist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y-b.y);
	}
	
	//경찰차가 i, j번째 사건까지 처리했을 때의 최소 이동 거리
	public static int dfs(int car1, int car2) {
		if(car1==W || car2==W) return 0;
		
		if(dp[car1][car2] != -1) return dp[car1][car2];
		
		int next = Math.max(car1, car2) + 1;
		
		//다음 사건을 car1이 맡는 경우
		int move1 = dfs(next, car2) 
				+ dist(car1==0?new Point(1,1):event[car1], event[next]);
		
		//다음 사건을 car2가 맡는 경우
		int move2 = dfs(car1, next)
				+ dist(car2==0?new Point(N,N):event[car2], event[next]);
		
		
		//더 작은 값을 선택하고, 경로 추적용 path 배열에 기록
		if(move1 < move2) {
			dp[car1][car2] = move1;
			path[car1][car2] = 1;
		} else {
			dp[car1][car2] = move2;
			path[car1][car2] = 2;
		}
		return dp[car1][car2];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		
		event = new Point[W+1];
		dp = new int[W+1][W+1]; // dp[i][j]: i번 사건까지 경찰차1이 처리하고, j번 사건까지 경찰차2가 처리한 후 상태에서 남은 사건들을 가장 최적으로 처리했을 때의 총 이동 거리
		path = new int[W+1][W+1]; // path[i][j]: 경찰차1이 i번째 사건까지, 경찰차2가 j번째 사건까지 처리했을 때, 다음사건(max(i,j)+1)을 누가 처리했는지 저장 
		for(int[] row: dp) Arrays.fill(row, -1);
		
		for(int i=1; i<=W; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			event[i] = new Point(x, y);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dfs(0,0)).append("\n");
		
		// 경로 추적
		int car1 = 0, car2 = 0;
		for(int i=0; i<W; i++) {
			int p = path[car1][car2];
			sb.append(p).append("\n");
			if(p == 1) {
				car1 = Math.max(car1, car2) + 1;
			}else {
				car2 = Math.max(car1, car2) + 1;
			}
			
		}
		System.out.println(sb);
	}
}
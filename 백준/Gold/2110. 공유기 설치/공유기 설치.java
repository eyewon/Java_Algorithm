import java.io.*;
import java.util.*;

class Main {

	//가장 인접한 두 공유기 사이의 거리가 dist이도록 공유기를 설치했을 때, 설치된 공유기 개수
	public static int cntRouter(int dist, int[] house) {
		int cnt = 1;
		int cur = house[0];
		
		for(int i=1; i<house.length; i++) {
			if(house[i]-cur >= dist) {
				cnt++;
				cur = house[i];
			}
		}
		return cnt;
	}
	
	//c개의 공유기 설치 가능한 최소 인접 거리 중 최댓값 (=upper bound)
	public static int upperSearch(int left, int right, int target, int[] house) {
		while(left <= right) {
			int mid = left + (right - left)/2;
			int installed = cntRouter(mid, house);
			
			if(installed >= target) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return left-1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		System.out.println(upperSearch(1, house[N-1]-house[0], C, house));
	}
}
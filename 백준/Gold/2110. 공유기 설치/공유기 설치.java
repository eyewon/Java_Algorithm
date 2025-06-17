import java.io.*;
import java.util.*;

class Main {
	static int C;
	static int N;
	static int[] x;
	public static boolean isPossible(int dis) {
		int cnt=1; //x[0]에 먼저 설치했다고 가정
		int cur = x[0];
		for(int i=1; i<N; i++) {
			if(x[i]-cur >= dis) {
				cnt++;
				cur = x[i];
			}
		}
		return cnt>=C; //
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		x = new int[N];
		for(int i=0; i<N; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(x);
		
		int left = 1;
		int right = x[N-1] - x[0];
		int result = 0;
		while(left <= right) {
			int mid = left + (right-left)/2 ;
			if(isPossible(mid)) {
				result = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(result);
	}
}
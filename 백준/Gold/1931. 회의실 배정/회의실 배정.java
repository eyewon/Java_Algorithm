import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(schedule, (a, b)->{
			if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
			return Integer.compare(a[1], b[1]);
		});
		
		int cur = 0;
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(cur <= schedule[i][0]) {
				cur = schedule[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
 	}
}
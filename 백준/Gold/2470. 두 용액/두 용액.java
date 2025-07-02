import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int start = 0, end = N-1, ans1 = 0, ans2 = 0;
		int minSum = Integer.MAX_VALUE;
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				ans1 = arr[start];
				ans2 = arr[end];
			}
			if(sum < 0) {
				start++;
			}else if(sum > 0) {
				end--;
			}else {
				ans1 = arr[start];
				ans2 = arr[end];
				break;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}
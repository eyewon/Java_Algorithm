import java.io.*;
import java.util.*;

class Main {
	
	public static int lowerBound(int[] arr, int len, int key) {
		int low = 0, high = len;
		
		while(low < high) {
			int mid = low + (high-low)/2 ;
			if(arr[mid] < key) {
				low = mid+1;
			}else {
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N]; // d[i]: 길이가 i+1인 LIS를 만들기 위한 최소 끝값
		int[] lisIdx = new int[N]; // arr[i]가 LIS의 몇 번째에 해당하는지 인덱스 저장
		
		int len = 0; // LIS의 길이
		for(int i=0; i<N; i++) {
			int pos = lowerBound(dp, len, arr[i]);
			
			dp[pos] = arr[i];
			lisIdx[i] = pos; // arr[i]는 LIS의 pos번째에 해당함
			
			if(pos == len) len++;
		}
		
		// 역추적
		int target = len-1; //LIS의 마지막 원소 위치
		List<Integer> lis = new ArrayList<>();
		for(int i = N-1; i>=0; i--) {
			if(lisIdx[i] == target) {
				lis.add(arr[i]);
				target--;
			}
		}
		Collections.reverse(lis);
		
		StringBuilder sb = new StringBuilder();
		sb.append(len).append("\n");
		for(int a: lis) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}
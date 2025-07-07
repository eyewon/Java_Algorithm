import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1]; // dp[i]: i번째 요소를 끝으로 하는 LIS의 최대 길이
		int[] parent = new int[N+1]; // i번째 요소의 이전 인덱스 
		Arrays.fill(parent, -1);
		
		int maxLen = 0, lastIdx = 0;
		for(int i=1; i<=N; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(A[j] < A[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
					parent[i] = j;
				}
			}
			if(dp[i] > maxLen) {
				maxLen = dp[i];
				lastIdx = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(maxLen).append("\n");
		
		List<Integer> li = new ArrayList<>();
		for(int i=lastIdx; i!=-1; i=parent[i]) {
			li.add(A[i]);
		}
		Collections.reverse(li);
		for(int i=0; i<li.size(); i++) {
			sb.append(li.get(i));
			if(i<li.size()-1) sb.append(" ");
		}
		System.out.println(sb);
	}
}
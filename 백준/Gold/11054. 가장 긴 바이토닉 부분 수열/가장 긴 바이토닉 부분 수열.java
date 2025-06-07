import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dpUp = new int[N+1]; //dpUp[i]: i번째 요소가 포함된 LIS 길이
		int[] dpDown = new int[N+1]; //dpDown[i]: i번째 요소가 포함된 LDS 길이
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			dpUp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[j] < arr[i]) dpUp[i] = Math.max(dpUp[i], dpUp[j]+1);
			}
		}
		for(int i=N; i>0; i--) {
			dpDown[i] = 1;
			for(int j=N; j>i; j--)
				if(arr[i] > arr[j]) dpDown[i]= Math.max(dpDown[i], dpDown[j]+1);
		}
		int max = 0;		
		for(int i=1; i<=N; i++) {
			max = Math.max((dpUp[i]+dpDown[i]-1), max);
		}
		System.out.println(max);
 	}
}
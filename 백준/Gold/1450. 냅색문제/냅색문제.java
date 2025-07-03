import java.io.*;
import java.util.*;

class Main {
	
	// 부분집합 합 생성 함수
	public static List<Long> getAllSubnetSums(long[] arr){
		int n = arr.length;
		List<Long> sums = new ArrayList<>();
		
		for(int mask = 0; mask < (1<<n); mask++) {
			long sum = 0;
			for(int i=0; i<n; i++) {
				if((mask & (1 << i)) != 0) {
					sum += arr[i];
				}
			}
			sums.add(sum);
		}
		
		return sums;
	}
	
	//Lower Bound
	public static int lowerBound(long[] arr, int k) {
		int left = 0, right = arr.length;
		
		while(left < right) {
			int mid = left + (right-left)/2;
			if(arr[mid] < k) left = mid+1;
			else right = mid;
		}
		return left;
	}
	
	//Upper Bound
	public static int upperBound(List<Long> arr, long k) {
		int left = 0, right = arr.size();
		
		while(left<right) {
			int mid = left + (right - left)/2;
			if(arr.get(mid) <= k) left = mid+1;
			else right = mid;
		}
		
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		long[] weight = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		// 반 나누기
		//Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스) [시작인덱스, 끝인덱스) 구간 복사
		long[] leftArr = Arrays.copyOfRange(weight, 0, N/2);
		long[] rightArr = Arrays.copyOfRange(weight, N/2, N);
		
		// 각 부분합 리스트 만들기
		List<Long> leftSums = getAllSubnetSums(leftArr);
		List<Long> rightSums = getAllSubnetSums(rightArr);
		
		Collections.sort(leftSums);
		
		long cnt = 0;
		for(long r : rightSums) {
			long remain = C - r;
			long upperBound = upperBound(leftSums, remain);
			cnt += upperBound;
		}
		
		System.out.println(cnt);
	}
}
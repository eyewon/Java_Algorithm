import java.io.*;
import java.util.*;

class Main {
	public static int lowerBound(int left, int right, int target, ArrayList<Integer> list) {
		while(left < right) {
			int mid = left + (right -left)/2;
			if(list.get(mid) < target) {
				left = mid+1;
			}else
				right = mid;
		}
		return left;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> list = new ArrayList<>();
		list.add(A[0]);
		for(int i=1; i<N; i++) {
			if(list.get(list.size()-1) < A[i]) {
				list.add(A[i]);
			}else {
				int idx = lowerBound(0, list.size(), A[i], list);
				list.set(idx, A[i]);
			}
		}
		System.out.println(list.size());
	}
}
import java.io.*;
import java.util.*;

class Main {
	
	public static long getArea(long[] arr, int left, int right) {
		if(left == right) return arr[left]; //하나일 경우
		
		int mid = (left + right)/2;
		long leftArea = getArea(arr, left, mid);
		long rightArea = getArea(arr, mid+1, right);
		long crossArea = getCrossArea(arr, left, right, mid);
		
		return Math.max(Math.max(rightArea, leftArea), crossArea);
	}
	
	public static long getCrossArea(long[] arr, int left, int right, int mid) {
		int l = mid, r = mid+1;
		long h = Math.min(arr[l], arr[r]);
		long max = h*2;
		
		while(left < l || r < right) {
			if(r < right && (l==left || arr[l-1] < arr[r+1])) {
				r++;
				h = Math.min(h, arr[r]);
			}else {
				l--;
				h = Math.min(h, arr[l]);
			}
			max = Math.max(max, h * (r-l+1));
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while(!((input = br.readLine()).equals("0"))) {
			StringTokenizer st = new StringTokenizer(input);
			int n = Integer.parseInt(st.nextToken());
			long[] hist = new long[n];
			for(int i=0; i<n; i++) {
				hist[i] = Long.parseLong(st.nextToken());
			}
			System.out.println(getArea(hist, 0, n-1));
		}
	}
}
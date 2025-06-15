import java.io.*;
import java.util.*;

class Main {
	
	public static long getArea(long[] arr) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		long max=0;
		while(i < arr.length) {
			if(stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			}else {
				long h = arr[stack.pop()];
				long w = stack.isEmpty()?i:i-(stack.peek()+1);
				max  = max < h*w? h*w: max;
			}
		}
		while(!stack.isEmpty()) {
			long h = arr[stack.pop()];
			long w = stack.isEmpty()?i:i-(stack.peek()+1);
			max  = max < h*w? h*w: max;
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
			System.out.println(getArea(hist));
		}
	}
}
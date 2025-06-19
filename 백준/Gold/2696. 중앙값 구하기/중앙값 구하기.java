import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int M = Integer.parseInt(br.readLine());
			int total = 0;
			
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			
			sb.append((M+1)/2).append("\n");
			
			int cnt = 0;
			int numbersRead = 0;
			
			while (numbersRead < M) {
				String[] line = br.readLine().split(" ");
				for(String numStr : line) {
					int num = Integer.parseInt(numStr);
					numbersRead++;
					
					if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
						maxHeap.offer(num);
					} else {
						minHeap.offer(num);
					}
					
					while (maxHeap.size() > minHeap.size() + 1) {
						minHeap.offer(maxHeap.poll());
					}
					while (minHeap.size() > maxHeap.size()) {
						maxHeap.offer(minHeap.poll());
					}
					
					if (numbersRead % 2 == 1) {
						sb.append(maxHeap.peek()).append(" ");
						cnt++;
						
						if(cnt % 10 == 0) {
							sb.append("\n");
						}
					}
				}
			}
			
			if(cnt % 10 != 0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
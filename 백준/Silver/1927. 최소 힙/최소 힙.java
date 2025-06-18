import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}else
					sb.append(pq.poll()).append("\n");
			}else {
				pq.add(input);
			}
		}
		System.out.println(sb);
	}
}
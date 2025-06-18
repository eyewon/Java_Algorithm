import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			if(Math.abs(a)==Math.abs(b)) return a-b;
			else return Math.abs(a)-Math.abs(b);
		});
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
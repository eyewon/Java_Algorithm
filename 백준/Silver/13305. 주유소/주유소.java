import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] road = new int[N-1];
		int[] pay = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0;
		int min = pay[0];
		
		for(int i=0; i<N-1; i++) {
			total += min*road[i];
			if(pay[i+1] < min)
				min = pay[i+1];
		}
		System.out.println(total);
 	}
}
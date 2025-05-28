import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	Queue<Integer> q= new LinkedList<>();
    	int[] arr = new int[N];
    	
    	for(int i=1; i<=N; i++) {
    		q.add(i);
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append('<');
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<K-1; j++) {
    			q.add(q.poll());
    		}
    		if(i==N-1) {
    			sb.append(q.poll());
    		}else
    			sb.append(q.poll()+", ");
    	}
    	sb.append('>');
    	System.out.print(sb);
    }
}
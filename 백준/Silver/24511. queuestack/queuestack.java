import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	int[] type = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		type[i]=Integer.parseInt(st.nextToken());
    		
    	}
    	
    	Deque<Integer> deque = new ArrayDeque<>();
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i<N; i++) {
    		int val = Integer.parseInt(st.nextToken());
    		if(type[i]==0)
    			deque.addLast(val);
    	}
    	
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(M > 0) {
    		int input = Integer.parseInt(st.nextToken());
    		deque.addFirst(input);
    		
    		sb.append(deque.pollLast()).append(" ");
    		M--;
    	}
    	System.out.print(sb);
    }
}

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	Deque<Integer> dq = new LinkedList<>();
    	
    	for(int i=1; i<=N; i++) {
    		dq.addLast(i);
    	}
    	
    	while(dq.size()>1) {
    		dq.pollFirst();
    		dq.addLast(dq.pollFirst());
    	}
    	System.out.print(dq.poll());
    }
}
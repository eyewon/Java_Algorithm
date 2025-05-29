import java.io.*;
import java.util.*;


class Main {
	static class Balloon{
		int num;
		int move;
		
		Balloon(int num, int move){
			this.num = num;
			this.move = move;
		}
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	Deque<Balloon> dq = new ArrayDeque<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	for(int i = 0; i<N; i++) {
    		dq.addLast(new Balloon(i+1, Integer.parseInt(st.nextToken())));
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
   
    	
    	for(int i = 0; i<N; i++) {
    		Balloon b = dq.pollFirst();
    		if(b.move>0) {
    			for(int j=0; j<b.move-1; j++) {
    				if(!dq.isEmpty()) {
    					dq.addLast(dq.pollFirst());
    				}
    			}
    		} else if(b.move<0) {
    			for(int j=0; j>b.move; j--) {
    				if(!dq.isEmpty()) {
    					dq.addFirst(dq.pollLast());;
    				}
    			}
    		}
    		sb.append(b.num+" ");
    	}
    	System.out.print(sb);
    }
}
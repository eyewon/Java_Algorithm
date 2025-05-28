import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	Deque<Integer> dq = new ArrayDeque<>();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String command = st.nextToken();
    		switch(command) {
    			case "1":
    				int x = Integer.parseInt(st.nextToken());
    				dq.addFirst(x);
    				break;
    			case "2":
    				int y = Integer.parseInt(st.nextToken());
    				dq.addLast(y);
    				break;
    			case "3":
    				if(!dq.isEmpty())
    					sb.append(dq.pollFirst()).append("\n");
    				else
    					sb.append(-1).append("\n");
    				break;
    			case "4":
    				if(!dq.isEmpty())
    					sb.append(dq.pollLast()).append("\n");
    				else
    					sb.append(-1).append("\n");
    				break;
    			case "5":
    				sb.append(dq.size()).append("\n");
    				break;
    			case "6":
    				if(dq.isEmpty())
    					sb.append(1).append("\n");
    				else
    					sb.append(0).append("\n");
    				break;
    			case "7":
    				if(!dq.isEmpty())
    					sb.append(dq.peekFirst()).append("\n");
    				else
    					sb.append(-1).append("\n");
    				break;
    			case "8":
    				if(!dq.isEmpty())
    					sb.append(dq.peekLast()).append("\n");
    				else
    					sb.append(-1).append("\n");
    				break;
    		}
    	}
    	
    	System.out.print(sb);
    }
}
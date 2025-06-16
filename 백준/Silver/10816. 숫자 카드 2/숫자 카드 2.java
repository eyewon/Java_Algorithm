import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int N = Integer.parseInt(br.readLine());
    	HashMap<String, Integer> map = new HashMap<>();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] arr = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		String input = st.nextToken();
    		map.put(input, map.getOrDefault(input, 0)+1);	
    	}
    	
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<M; i++) {
    		String input = st.nextToken();
    		sb.append(map.get(input)==null? 0: map.get(input)).append(" ");
    	}
    	
    	System.out.println(sb);
    }
}
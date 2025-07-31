import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String[] word = new String[N];
    	for(int i = 0; i < N; i++) {
    		word[i]=br.readLine();
    	}
    	Arrays.sort(word, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			if(o1.length()==o2.length()) return o1.compareTo(o2);
    			return Integer.compare(o1.length(), o2.length());
    		}
    	});
    	String pre = " ";
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		if(pre.equals(word[i])) continue;
    		sb.append(word[i]).append("\n");
    		pre = word[i];
    	}
    	System.out.println(sb);
    }
}
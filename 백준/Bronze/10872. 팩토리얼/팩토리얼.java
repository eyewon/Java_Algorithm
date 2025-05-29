import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int solution = 1;
    	
    	for(int i=1; i<=N; i++) {
    		solution *= i;
    	}
    	System.out.println(solution);
    }
}
import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int solution = factorial(N) / (factorial(K)*factorial(N-K));
    	System.out.println(solution);
    }
    
    public static int factorial(int n) {
    	int result = 1;
    	for(int i=1;i<=n;i++)
    		result *= i;
    	return result;
    }
}
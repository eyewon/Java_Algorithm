import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int result = A * B * C;
		int count[] = new int[10];
		
		while(result > 0) {
			count[result%10]++;
			result /= 10;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(count[i]);
		}
	}
}
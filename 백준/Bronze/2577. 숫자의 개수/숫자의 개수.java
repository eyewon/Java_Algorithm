import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int result = A * B * C;
		int count[] = new int[10];
		
		String result_str = String.valueOf(result);
		for(int i=0; i<result_str.length(); i++) {
			int j = result_str.charAt(i) - '0';
			count[j]++;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(count[i]);
		}
	}
}
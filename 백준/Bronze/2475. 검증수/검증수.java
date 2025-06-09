import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		int sum=0;
		
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i]*arr[i];
		}
		System.out.println(sum%10);
	}
}
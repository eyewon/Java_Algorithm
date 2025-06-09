import java.io.*;
import java.util.*;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int solved = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		if(n>=1) {
			int slice = (int)Math.round(n*(0.15));
			int total = n-slice*2;
			double sum = 0;
			for(int i=0; i<total; i++) {
				sum += arr[slice+i];
			}
			solved = (int)Math.round(sum/total);
		}
		System.out.println(solved);
	}
}
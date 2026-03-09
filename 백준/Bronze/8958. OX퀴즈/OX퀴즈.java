import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 0; testcase < T; testcase++) {
			char[] input = br.readLine().toCharArray();
			int[] count = new int[input.length];
			int sum = 0;
			
			for(int i=0; i<input.length; i++) {
				if(input[i]=='X') {
					count[i]=0;
				}else {
					if(i==0) count[i]=1;
					else count[i] = count[i-1]+1;
				}
				sum+=count[i];
			}
			
			System.out.println(sum);
		}
	}
}
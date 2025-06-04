import java.io.*;
import java.util.*;

class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] size = new int[6]; // ,s,m,l,xl,xxl,xxxl
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Arrays.sort(size);
		int sum=0;
		for(int i=0; i<6; i++) {
			int t=0;
			while(t*T < size[i])
				t++;
			sum+=t;
		}
		
		int p1 = N/P;
		int p2 = N%P;
		
		System.out.println(sum);
		System.out.println(p1+" "+p2);
 	}
}
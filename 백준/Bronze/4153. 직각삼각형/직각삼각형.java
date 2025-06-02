import java.io.*;
import java.util.*;

class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		StringBuilder sb = new StringBuilder();
		
		while((st = br.readLine())!= null) {
			if(st.equals("0 0 0"))
				break;
			String[] input = st.split(" ");
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(input[0]);
			arr[1] = Integer.parseInt(input[1]);
			arr[2] = Integer.parseInt(input[2]);
			Arrays.sort(arr);
			
			if(arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2]) {
				sb.append("right").append("\n");
			}else
				sb.append("wrong").append("\n");
		}
		System.out.print(sb);
	}
}
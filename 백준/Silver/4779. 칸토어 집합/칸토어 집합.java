import java.io.*;
import java.util.*;

class Main{
	static List<Integer> list = new ArrayList<>();
	
	public static void separate(char[] input, int start, int size) {
		if(size == 1)
			return;
		
		int len = size/3;
		for(int k=start+len; k<start+2*len; k++) {
			input[k] = ' ';
		}
		separate(input, start, size/3);
		separate(input, start+2*len, size/3);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;

		while((input=br.readLine()) != null) {
			int N = Integer.parseInt(input);
			int size = (int)Math.pow(3, N);
			char[] arr= new char[size];
			for(int i=0; i<size; i++)
				arr[i]='-';
			
			separate(arr, 0, size);
			sb.append(arr).append("\n");

		}
		System.out.print(sb);
	}
}
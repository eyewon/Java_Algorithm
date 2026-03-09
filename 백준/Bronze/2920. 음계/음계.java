import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		String output;
		
		if(input.equals(ascending)) {
			output = "ascending";
		}else if(input.equals(descending)) {
			output = "descending";
		}else {
			output = "mixed";
		}
		
		System.out.println(output);
	}
}
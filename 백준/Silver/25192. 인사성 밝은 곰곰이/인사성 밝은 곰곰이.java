import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int sum=0;
		
		for(int i=0; i<N; i++) {
			String chat = br.readLine();
			if(chat.equals("ENTER")) {
				sum+=set.size();
				set.clear();
			}else {
				set.add(chat);
			}
		}
		sum+=set.size();
		System.out.println(sum);
	}
}
import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		set.add("ChongChong");
		
		for(int i=0; i<N; i++) {
			String[] recored = br.readLine().split(" ");
			if(set.contains(recored[0]) || set.contains(recored[1])) {
				set.add(recored[0]);
				set.add(recored[1]);
			}
		}
		int sum = set.size();
		System.out.println(sum);
	}
}
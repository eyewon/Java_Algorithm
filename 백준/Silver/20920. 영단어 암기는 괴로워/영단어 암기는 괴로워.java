import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<N; i++) {
			String input = br.readLine();
			if(input.length()>=M) {
				map.put(input, map.getOrDefault(input, 0)+1);
			}
		}
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

		Collections.sort(list, (e1, e2)->{
			if(e1.getValue() != e2.getValue()) 
				return e2.getValue()-e1.getValue();
			else if(e1.getKey().length() != e2.getKey().length())
				return e2.getKey().length() - e1.getKey().length();
			else
				return e1.getKey().compareTo(e2.getKey());
		});

		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String, Integer> e: list) {
			sb.append(e.getKey()).append("\n");
		}
		System.out.println(sb);
	}
}
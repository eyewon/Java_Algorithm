import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i=0; i<M; i++) {
			String[] command = br.readLine().split(" ");
			
			String s = command[0];
			int x;
			switch(s) {
			case "add":
				x = Integer.parseInt(command[1]);
				set.add(x);
				break;
			case "remove":
				x = Integer.parseInt(command[1]);
				set.remove(x);
				break;
			case "check":
				x = Integer.parseInt(command[1]);
				boolean isContain = set.contains(x);
				bw.append(isContain?"1":"0").append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(command[1]);
				if(set.contains(x)) {
					set.remove(x);
				}else {
					set.add(x);
				}
				break;
			case "all":
				set.clear();
				for(int j=1; j<=20; j++) set.add(j);
				break;
			case "empty":
				set.clear();
				break;
			}
			
		}
		bw.flush();
		
	}
}
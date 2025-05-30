import java.io.*;
import java.util.*;

class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		double sum=0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum+=arr[i];
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		int max=0;
		Set<Integer> maxvalue= new HashSet<>();
		for(int k: map.keySet()) {
			if(max < map.get(k)) {
				max = map.get(k);
				maxvalue.clear();
				maxvalue.add(k);
			}else if(max == map.get(k)) {
				maxvalue.add(k);
			}
		}
		Arrays.sort(arr);
		ArrayList<Integer> list = new ArrayList<>(maxvalue);
		Collections.sort(list);
		int avg = (int)Math.round(sum/N);
		int mid = arr[N/2];
		int fre = list.size()>1? list.get(1): list.get(0);
		int range = arr[N-1] - arr[0];
		System.out.println(avg+"\n"+mid+"\n"+fre+"\n"+range);
	}
}
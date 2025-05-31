import java.io.*;
import java.util.*;

class Main{
	static List<Integer> list = new ArrayList<>();
	
	public static void merge_sort(int[] arr, int i, int j) {
		if(i < j) {
			int q = (i+j) / 2;
			merge_sort(arr, i, q);
			merge_sort(arr, q+1, j);
			merge(arr, i, q, j);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r) {
		int[] temp = new int[r-p+1];
		int t=0;
		int i=p;
		int j=q+1;
		while(i<=q && j<=r) {
			if(arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		while(i<=q) {
			temp[t++] = arr[i++];
		}
		while(j<=r) {
			temp[t++] = arr[j++];
		}
		for(int idx=0; idx<t; idx++) {
			arr[idx+p] = temp[idx];
			list.add(arr[idx+p]);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(arr, 0, N-1);
		System.out.println(list.size() < K? -1: list.get(K-1));
		
	}
	
}
import java.io.*;
import java.util.*;

class Main {
	static int cntB = 0;
	static int cntW = 0;
	
	public static String compress(int[][] arr, int x, int y, int N) {
		if(canCompress(arr, x, y, N)) {
			return Integer.toString(arr[x][y]);
		}
		
		int n = N/2;
		String leftUp = compress(arr, x, y, n);
		String rightUp = compress(arr, x, y+n, n);
		String leftDown = compress(arr, x+n, y, n);
		String rightDown = compress(arr, x+n, y+n, n);
		return "("+leftUp+rightUp+leftDown+rightDown+")";
	}
	
	public static boolean canCompress(int[][] arr, int x, int y, int N) {
		int cur = arr[x][y];
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(arr[i][j]!=cur)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] video = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<N; j++) {
				video[i][j] = Integer.parseInt(st[j]);
			}
		}
		System.out.println(compress(video, 0, 0, N));
	}
}
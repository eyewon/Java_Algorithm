import java.io.*;
import java.util.*;

class Main {
	static int cntB = 0;
	static int cntW = 0;
	
	public static void countPaper(int[][] arr, int x, int y, int N) {
		if(isBlue(arr, x, y, N)) {
			cntB++;
			return;
		}
		if(isWhite(arr, x, y, N)) {
			cntW++;
			return;
		}
		int n = N/2;
		countPaper(arr, x, y, n);
		countPaper(arr, x, y+n, n);
		countPaper(arr, x+n, y, n);
		countPaper(arr, x+n, y+n, n);
	}
	
	public static boolean isBlue(int[][] arr, int x, int y, int N) {
		for(int i = x; i<x+N; i++) {
			for(int j = y; j < y+N; j++) {
				if(arr[i][j]!=1) return false;
			}
		}
		return true;
	}
	
	public static boolean isWhite(int[][] arr, int x, int y, int N) {
		for(int i = x; i<x+N; i++) {
			for(int j = y; j < y+ N; j++) {
				if(arr[i][j]!=0) return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		countPaper(paper, 0, 0, N);
		System.out.println(cntW);
		System.out.println(cntB);
	}
}
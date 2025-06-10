import java.io.*;
import java.util.*;

class Main {
	static int cnt1 = 0;
	static int cnt0 = 0;
	static int cntM = 0;
	
	public static void cutPaper(int[][] arr, int x, int y, int N) {
		if(canCut(arr, x, y, N)) {
			int temp = arr[x][y];
			if(temp==1) cnt1++;
			else if(temp==0) cnt0++;
			else cntM++;
			return;
		}
		
		int n = N/3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				cutPaper(arr, x+i*n, y+j*n, n);
			}
		}
	}
	
	public static boolean canCut(int[][] arr, int x, int y, int N) {
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
		int[][] paper = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cutPaper(paper, 0, 0, N);
		System.out.println(cntM);
		System.out.println(cnt0);
		System.out.println(cnt1);
	}
}
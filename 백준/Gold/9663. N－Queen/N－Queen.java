import java.io.*;
import java.util.*;

class Main{	
	public static int backtracking(int N, int row, boolean[] col, boolean[] dial_up, boolean[] dial_down) {
		if(row==N) {
			return 1;
		}
		int cnt = 0;
		for(int c=0; c<N; c++) {
			if(col[c] || dial_up[row+c] || dial_down[row-c+N-1])
				continue;
			col[c] = true;
			dial_up[row+c] = true;
			dial_down[row-c+N-1] = true;
			cnt+=backtracking(N, row+1, col, dial_up, dial_down);
			col[c] = false;
			dial_up[c+row] = false;
			dial_down[row-c+N-1] = false;
		}
		return cnt;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[] col = new boolean[N];
		boolean[] dial_up = new boolean[2*N-1];
		boolean[] dial_down = new boolean[2*N-1];
		
		System.out.print(backtracking(N,0,col, dial_up, dial_down));
		
	}
}
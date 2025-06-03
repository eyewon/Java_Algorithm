import java.io.*;
import java.util.*;

class Main {
	static int cnt = 0;
	static int N;

	public static void backtracking(int row, boolean[] col, boolean[] dial_up, boolean[] dial_down) {
		if (row == N) {
			cnt++;
			return;
		}

		for (int c= 0; c<N; c++) {
			if (col[c] || dial_up[row+c] || dial_down[row-c+N-1]) {
				continue;
			}
			col[c] = true;
			dial_up[row+c] = true;
			dial_down[row-c+N-1] = true;
			backtracking(row + 1, col, dial_up, dial_down);
			col[c] = false;
			dial_up[row+c] = false;
			dial_down[row-c+N-1] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[] col = new boolean[N];
		boolean dial_up[] = new boolean[2*N-1];
		boolean dial_down[] = new boolean[2*N-1];
		backtracking(0, col, dial_up, dial_down);
		System.out.println(cnt);
	}
}
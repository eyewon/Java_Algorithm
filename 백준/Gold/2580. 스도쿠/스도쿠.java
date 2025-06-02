import java.io.*;
import java.util.*;

class Main{	
	static int[][] sdoku = new int[9][9];

	
	public static void backtracking(int row, int col) {

		if(col == 9) {
			backtracking(row+1, 0);
			return;
		}
			
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(sdoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
			System.exit(0); // 해 찾자마자 프로그램 종료
		}
		
		if(sdoku[row][col] != 0)
			backtracking(row, col+1);
		else {
			for(int num = 1; num <= 9; num++) {
				if(canPut(row, col, num)) {
					sdoku[row][col] = num;
					backtracking(row, col+1);
					sdoku[row][col] = 0;
				}
			}
		}
	}
	
	public static boolean canPut(int row, int col, int num) {
		for(int i=0; i<9; i++) {
			if(sdoku[row][i]==num || sdoku[i][col]==num) 
				return false;
		}
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;
		
		for(int i=startRow; i<startRow+3; i++) {
			for(int j=startCol; j<startCol+3; j++) {
				if(sdoku[i][j] == num)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				int input = Integer.parseInt(st.nextToken());
				sdoku[i][j]=input;
			}
		}
		backtracking(0,0);
		
	}
}
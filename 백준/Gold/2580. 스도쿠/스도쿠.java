import java.io.*;
import java.util.*;

class Main {
	static int[][] board =new int[9][9];
	static int N;

	public static void backtracking(int row, int col) {
		
		if (row == 9) {
			printBoard();
			System.exit(0);
		}
		if(col == 9) {
			backtracking(row+1, 0);
			return;
		}
		if(board[row][col] != 0)
			backtracking(row, col+1);
		else{
         for(int num=1; num<=9; num++) {
			if(canPut(num, row, col)) {
				board[row][col] = num;
				backtracking(row, col+1);
				board[row][col] = 0;
			}
		}   
            
        }
	}
	
	public static boolean canPut(int num, int row, int col) {
		for(int i=0; i<9; i++) {
			if(board[row][i] == num) return false;
			if(board[i][col] == num) return false;
		}
		
		int startX = (row/3) *3;
		int startY = (col/3) *3;
		
		for(int i=startX; i<startX+3; i++) {
			for(int j=startY; j<startY+3; j++) {
				if(board[i][j] == num) return false;
			}
		}
		
		return true;
	}
	
	public static void printBoard() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtracking(0,0);
	}
}
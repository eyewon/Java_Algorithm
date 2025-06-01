import java.io.*;
import java.util.*;

class Main{

	public static void draw(char[][] star, int x, int y, int size) {
		if(size < 3) {
			return;
		}
		int n = size/3;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				star[x+n+i][y+n+j] = ' ';
			}
		}
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1)
					continue;
				draw(star,x+i*n,y+j*n,n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		char[][] star = new char[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star[i][j] = '*';
			}
		}
		draw(star,0,0,N);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
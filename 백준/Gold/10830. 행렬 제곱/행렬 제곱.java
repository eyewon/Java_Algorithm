import java.io.*;
import java.util.*;

class Main {
	static int N;
	
	public static long[][] mulMat(long[][] arr, long[][] arr2) {
		long[][] result= new long[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					result[i][j] += (arr[i][k]*arr2[k][j]) %1000;
				}
				result[i][j] %= 1000;
			}
		}
		return result;
	}
	
	public static long[][] matPow(long[][] arr, long b) {
		if(b==1) {
			long[][] result = new long[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					result[i][j] = arr[i][j] %1000;
				}
			}
			return result;
		}
		
		long[][] half = matPow(arr, b/2);
		long[][] halfSquared = mulMat(half, half);
		
		if(b%2 == 1) {
			return mulMat(halfSquared, arr);
		}else {
			return halfSquared;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long[][] mat = new long[N][N];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] result = matPow(mat, B);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
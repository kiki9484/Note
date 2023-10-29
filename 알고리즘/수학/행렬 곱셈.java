// C = A * B, (A = n*m행렬, B = m*r행렬)
public static int[][] multiply(int[][] a, int[][] b){
	int[][] C = new int[N][R];
	for(int i = 0; i < N; i++)
		for(int j = 0; j < R; j++)
			for(int k = 0; k < M; k++)
				C[i][j] += A[i][k] * B[k][j];
	return C;
}

/* 2와 5의 개수를 모두 구한다.
 *  출력: Math.min(calc(N, M, 2), calc(N, M, 5));
 */

public static int calc(int N, int M, int num){
	int ret = 0;
	for(int i = num; i <= N; i *= num) ret += N / i;
	for(int i = num; i <= M; i *= num) ret -= M / i;
	for(int i = num; i <= N-M; i *= num) ret -= (N-M) / i;
	return ret;
}

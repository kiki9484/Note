public static int[][] fenwickTree;

public static int sum(int y, int x){
    int ret = 0;
    for(int i = y; i <= N; i -= i&-i){
        for(int j = x; j <= N; j -= j&-j){
						ret += tree[i][j];
        }
    }
    return ret;
}

public static void update(int y, int x, int val){
		for(int i = y; i <= N; i += i&-i){
        for(int j = x; j <= N; j += j&-j){
            tree[i][j] += val;
         }
    }
}

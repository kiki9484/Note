public static int[] fenwickTree; // fenwickTree[i] = [0..i]인 구간합

public static int sum(int pos){ // 합 구하기
    int ret = 0;
    while(pos > 0){
        ret += fenwickTree[pos];
        pos -= (pos & -pos);
    }
    return ret;
}

public static void update(int pos, int val){ // 갱신하기
    while(pos <= N){
        fenwickTree[pos] += val;
        pos += (pos & -pos);
    }
}

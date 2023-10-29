public static int hash(String s){
	int ret = 0;
	for(int i = 0; i < s.length(); i++){
		char ch = s.charAt(i);
		ret = (ret * base + ch) % mod;
	}
	return ret;
}

public static int rabinKarp(){
	int n = H.length();
	int m = N.length();
	if(n < m) return 0;

	int hashH = hash(H.substring(0, m));
	int hashN = hash(N);
	int first = 1;

	for(int i = 0; i < m - 1; i++)
		first = (first * base) % mod;
		for(int i = 0; i <= n - m; i++){
			if(hashN == hashH && H.substring(i, i + m).equals(N)) return 1;
			if(i + m < n){
				hashH = (hashH - ((H.charAt(i) * first) % mod) + mod) % mod;
				hashH = ((hashH * base) % mod + H.charAt(i + m)) % mod;    
			}
		}
	return 0;
}

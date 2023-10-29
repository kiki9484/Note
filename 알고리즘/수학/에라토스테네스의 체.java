public static boolean eratosthenes(int n){
  boolean[] check = new boolean[n+1];
  List<Integer> primes = new ArrayList<>();
  check[0] = check[1] = true;
  for(int i = 2; i <= n; i++){
    if(!check[i]){
      primes.add(i);
      for(int j = i*i; j <= n; j += i) 
        check[j] = true;
    }
  }
}

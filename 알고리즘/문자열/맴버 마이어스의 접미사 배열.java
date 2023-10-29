static class Comp implements Comparator<Integer>{
  public int[] group;
  public int t;
  
  public Comp(int[] group, int t){
      this.group = group;
      this.t = t;
  }
  
  @Override
  public int compare(Integer a, Integer b) {
      if(group[a] != group[b]) return Integer.compare(group[a], group[b]);
      return Integer.compare(group[a + t], group[b + t]);
  }
}

public static int[] getSuffixArray(String s){
  int n = s.length();
  
  int t = 1;
  int[] group = new int[n+1];
  for(int i = 0; i < n; i++) group[i] = s.charAt(i);
  group[n] = -1;
  
  Integer[] perm = new Integer[n];
  for(int i = 0; i < n; i++) perm[i] = i;

  while(t < n){
      Comp comp = new Comp(group, t);
      Arrays.sort(perm, comp);
      t *= 2;
      if(t >= n) break;
      
      int[] newGroup = new int[n+1];
      newGroup[n] = -1;
      newGroup[perm[0]] = 0;
      
      for(int i = 1; i < n; i++)
          if(comp.compare(perm[i-1], perm[i]) != 0)
              newGroup[perm[i]] = newGroup[perm[i-1]] + 1;
          else
              newGroup[perm[i]] = newGroup[perm[i-1]];
      group = newGroup;
  }
  return Arrays.stream(perm).mapToInt(Integer::intValue).toArray();
}

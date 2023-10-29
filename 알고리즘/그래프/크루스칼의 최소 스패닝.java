static class Edge{
  public int u;
  public int v;
  public int w;
  public Edge(int u, int v, int w){
    this.u = u;
    this.v = v;
    this.w = w;
  }
}

public static int[] parent;
public static int[] rank;

public static int kruskal(){
  for(int i = 0; i < N; i++) parent[i] = i;
  for(int i = 0; i < N; i++) rank[i] = 1;
  int ret = 0;
  for(Edge edge: edges){
    if(find(edge.u) == find(edge.v)) continue;
    union(edge.u, edge.v);
    ret += edge.w;
  }
  return ret;
}

public static int find(int x){
  if(x == parent[x]) return x;
  return parent[x] = find(parent[x]);
}

public static void union(int u, int v){
  u = find(u);
  v = find(v);
  if(u == v) return;
  if(rank[u] > rank[v]) swap(u, v);
  parent[u] = v;
  if(rank[u] == rank[v]) rank[v]++;
}

public static void swap(int u, int v){
  int tmp = u;
  u = v;
  v = tmp;
}

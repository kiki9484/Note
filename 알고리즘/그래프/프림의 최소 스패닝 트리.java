static class Node{
  public int v;
  public int w;
  public Node(int v, int w){
    this.v = v;
    this.w = w;
  }
}

public static List<List<Node>> graph = new ArrayList<>();

public static double prim(int start){
  int ret = 0;
  boolean[] visited = new boolean[N];
  int[] dist = new int[N];
  PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
  Arrays.fill(dist, INF);
  dist[start] = 0;
  pq.add(new Node(start, 0));

  while(!pq.isEmpty()){
    Node here = pq.poll();
    if(visited[here.v]) continue;
    visited[here.v] = true;
    ret += here.w;
    for(Node next: graph.get(here.v)){
      if(!visited[next.v] && next.w < dist[next.v]){
      dist[next.v] = next.w;
      pq.add(next);
      }
    }
  }
  return ret;
}

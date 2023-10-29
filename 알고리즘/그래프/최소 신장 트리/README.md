### 최소 신장 트리

* 연결 무방향 그래프 G = (V, E)에서 V를 정점, E를 간선, w(u, v)를 각 간선(u, v) $\in$ E마다 u와 v를 연결하는 비용을 나타내는 가중치를 둔다.

* 모든 정점을 연결하고 전체 가중치의 합을 최소화하는 비순환 부분 집합 T $\subset$ E를 찾는다. T는 비순환이고 모든 정점을 연결하기 때문에 트리를 형성한다. 트리 T를 결정하는 문제를 최소 신장 트리 문제라고 한다.

$$ w(T) = \sum_{(u,v)\in T}w(u, v)$$

<hr>

### 최소 신장 트리의 확장

* 각 정점은 진행 정도에 따라 흰색, 회색, 검은색으로 칠해진다. 모든 정점은 흰색으로 시작해 회색이 됐다가 검은색으로 된다.

* 검색 도중에 처음으로 발견되면 흰색이 아닌 다른 색으로 바뀐다. 

* 회색 정점은 발견은 되었지만, 아직 인접 리스트에 완전히 조사되지 않은 정점이다. 또한, 인접한 흰색 정점을 가질 수 있는데 이는 발견된 정점과 발견되지 않은 정점 사이에 있는 경계선을 나타낸다.

* 검은색 정점은 인접해 있는 모든 정점이 발견된 것이다. 따라서, (u, v) $\in$ E에서 정점 u가 검은색이면, 정점 v는 회색이거나 검은색이다.

<hr>

### 의사코드

* 흰색 정점: 발견하지 못한 정점

* 회색 정점: 발견되었지만 아직 인접 리스트에 완전히 조사되지 않은 정점

* 검은색 정점: 발견된 정점

BFS(G, s)

&nbsp;&nbsp;&nbsp;&nbsp;for 각각의 정점 u $\in$ G.V - {s}
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u.color = WHITE
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u.d = $\infty$
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u. $\pi$ = NULL
  
&nbsp;&nbsp;&nbsp;&nbsp;s.color = GRAY
		
&nbsp;&nbsp;&nbsp;&nbsp;s.d = 0
		
&nbsp;&nbsp;&nbsp;&nbsp;s. $\pi$ = NULL
		
&nbsp;&nbsp;&nbsp;&nbsp;Q = $\pi$
		
&nbsp;&nbsp;&nbsp;&nbsp;Enqueue(Q, s)
		
&nbsp;&nbsp;&nbsp;&nbsp;while Q $\not = $\pi$
		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u = Dequeue(Q)
			
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for 각각의 정점 v $\in$ G.Adj[u]
			
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if u.color == WHITE
				
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;v.color = GRAY
				
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;v.d = u.d + 1
				
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;v. $\pi$ = u
				
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enqueue(Q, v)
		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;u.color = BLACK

<hr>

### 시간 복잡도

1. 각 정점이 큐에 최대 한 번 들어가게 된다.(빠져나오는 것도 한 번이다)
    
    → 큐에 삽입 및 제거는 O(1)이므로 총 O(V)이다.
    
2. 각 정점의 인접 리스트를 큐에서 제가될 때만 보기 때문에 각 인접 리스트를 최대 한 번 본다.
    
    → 인접 리스트의 길이의 총 합은 O(E)이다. 
    

 $\therefore$  BFS는 총 O(V+E)의 시간이 소모된다.
 
<hr>

### 최단경로 증명

최단 거리 $\delta$(s,v) = 정점 s에서 v까지의 모든 경로에 있는 간선의 개수 중 가장 작은 수 (s와 v사이에 경로가 없을 경우, $\delta$(s,v) = $\infty$)

**보조정리 1.**

G = (V, E)를 방향 또는 무방향 그래프라 하고, s $\in$ V를 임의의 정점이라 하자. 그러면 (u, v) $\in$ E에 대해 다음이 성립한다.

⇒ $\delta$(s,v) ≤ $\delta$(s,u) + 1

**보조정리 2.**

G = (V, E)를 방향 또는 무방향 그래프라 하고, BFS를 그래프 G에서 주어진 출발점 s $\in$ V로부터 수행시킨다고 하자. BFS가 종료 시, 각 정점 v $\in$ V에 대해 $v.d \ge \delta(s,v)$를 만족한다.

**증명 2.**

귀납법을 사용한다. 가정은 모든 v $\in$ V에 대해 $v.d \ge \delta(s, v)$이다.

정점 u부터 검색하는 동안 발견된 흰색 정점 v를 생각해보자. 귀납 가정을 통해 $u.d \ge \delta(s,u)$이므로, $v.d = u.d + 1$ ≥ $\delta(s,u) + 1 \ge \delta(s,v)$다.

이후, 정점 v는 큐에 들어가고 회색이 된 후, 다시 큐에 들어가지 않는다. 

그러므로, v.d값이 다시 변하지 않고 귀납 가정이 유지된다.

**보조정리 3.**
 
그래프 G = (V, E)에 대해 BFS를 수행하면서 큐 Q는 정점 < $v_1$, $v_2$, …, $v_r$ >을 가지고, $v_1$은 Q의 머리에, $v_r$은 Q의 꼬리에 위치한다고 가정하자. 

i = 1, 2, …, r-1일 때, $v_r.d \le v_1.d+1$이고, $v_i.d \le v_{i+1}.d$다.

**증명 3.**

큐 연산의 개수에 대한 귀납법을 이용한다. 큐에 정점을 하나 삽입하거나 삭제한 후에도 보조정리3이 성립함을 증명한다.

Q의 머리인 $v_1$이 삭제된다면, $v_2$가 새로운 머리가 된다. 귀납 가정에 의해, $v_1.d \le v2.d$다. $v_r.d \le v_1.d+1 \le v_2.d+1$이므로 삭제 연산에 대해서 성립한다.

Q에 정점 하나를 삽입하면 이것은 $v_{r+1}$이 된다. 인접 리스트를 탐색하는 중 노드 u는 Q에서 이미 제거되었고, 귀납 가정에 의해 새로운 헤드 $v_1$은 $v_1.d \ge u.d$가 된다. $v_r.d \le u.d+1 = v.d = v_{r+1}.d$이므로 Q에 정점이 삽입될 때도 성립한다.

**따름정리 4.**

BFS를 수행하는 도중에 정점 $v_i$와 $v_j$가 Q에 들어가 있고, $v_i$가 $v_j$보다 먼저 삽입된다고 가정할 때, $v_i.d \le v_j.d$다.

**증명 4.**

보조정리 3과 BFS수행 도중 각 정점은 최대 한 번 d값을 받는다는 특성을 통해 증명된다.

**정리 5.**

G = (V, E)는 방향 또는 무방향 그래프고 주어진 출발점 s $\in$ V로부터 G에서 BFS가 수행된다고 가정하자. 출발점 s로부터 도달할 수 있는 모든 정점 v $\in$ V를 찾고, 끝나면 모든 정점 v $\in$ V에 대해 $v.d = \delta(s,v)$가 된다.

또한, s에서 도달할 수 있는 v $\not =$  s인 어떤 정점 v에 대해서도 s로부터 v까지의 최단 경로 중 하나는 s에서 $v.\pi$까지의 최단 경로에 간선 $(v.\pi, v)$가 바로 뒤에 붙어 있는 경로다.

$\therefore$ $v.\pi = u$라면 $v.d = u.d+1$이다. s에서 $v.\pi$까지의 최단 경로를 구한 후, 간선 $(v.\pi, v)$를 탐색하여 s에서 v까지의 최단 경로를 얻을 수 있다.

<hr>

### 자바 코드

```java
public static void bfs(int start){
  int[] dist = new int[N];
  int[] parent = new int[N];
  Queue<Integer> queue = new LinkedList<>();
  Arrays.fill(dist, -1);
  Arrays.fill(parent, -1);
  dist[start] = 0;
  parent[start] = start;
  queue.add(start);

  while(!queue.isEmpty()){
    int here = queue.poll();
    for(int there: graph.get(here)){
      if(dist[there] == -1){
      queue.add(there);
      dist[there] = dist[here]+1;
      parent[there] = here;
    }
  }
}

public static List<Integer> shortestPath(int v, int[] parent){
  List<Integer> path = new ArrayList<>();
  while(parent[v] != v){
    v = parent[v];
    path.add(v);
  }
  Collections.reverse(path);
  return path;
}
```

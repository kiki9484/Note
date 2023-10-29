public static void union(int a, int b){
	int u = find(a);
	int v = find(b);
	if(u == v) return;
	if(rank[u] > rank[v]){
	    int tmp = u;
	    u = v;
	    v = tmp;
	}
	parent[u] = v;
	if(rank[u] == rank[v]) rank[v]++;
}
    
public static int find(int a){
	if(parent[a] == a) return a;
	return parent[a] = find(parent[a]);
}

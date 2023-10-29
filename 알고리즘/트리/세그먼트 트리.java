static class RMQ{
  private int size;
  private int[] rangeMin;
  public RMQ(int[] arr){
      size = arr.length;
      rangeMin = new int[size*4];
      init(arr, 0, size-1, 1);
  }
  
  public int query(int left, int right){
      return queryUtil(left, right, 1, 0, size-1);
  }
  
  public int update(int index, int newValue){
      return updateUtil(index, newValue, 1, 0, size-1);
  }
  
  private int init(int[] arr, int left, int right, int node){
      if(left == right) return rangeMin[node] = arr[left];
      int mid = (left + right) / 2;
      int leftMin = init(arr, left, mid, node * 2);
      int rightMin = init(arr, mid+1, right, node*2 + 1);
      return rangeMin[node] = Math.min(leftMin, rightMin);
  }
  
  private int queryUtil(int left, int right, int node, int nodeLeft, int nodeRight){
      if(right < nodeLeft || nodeRight < left) return Integer.MAX_VALUE;
      if(left <= nodeLeft && nodeRight <= right) return rangeMin[node];
      int mid = (nodeLeft + nodeRight) / 2;
      return Math.min(queryUtil(left, right, node*2, nodeLeft, mid), queryUtil(left, right, node*2+1, mid+1, nodeRight));
  }
  
  private int updateUtil(int index, int newValue, int node, int nodeLeft, int nodeRight){
      if(index < nodeLeft || nodeRight < index) return rangeMin[node];
      if(nodeLeft == nodeRight) return rangeMin[node] = newValue;
      int mid = (nodeLeft + nodeRight) / 2;
      return rangeMin[node] = Math.min(
          updateUtil(index, newValue, node*2, nodeLeft, mid),
          updateUtil(index, newValue, node*2 + 1, mid + 1, nodeRight)
      );
	}
}

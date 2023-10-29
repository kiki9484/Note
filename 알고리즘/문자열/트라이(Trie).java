static class Node{
  Map<Character, Node> children = new HashMap<Character, Node>();
	boolean endOfword;
}	

static class TrieNode{
  Node rootNode = new Node(); 
  public TrieNode(){}
  public void insert(String str) {
    Node node = this.rootNode;
    for(int i = 0; i < str.length(); i++) 
      node = node.children.computeIfAbsent(str.charAt(i), key -> new Node());  
      node.endOfword = true;
  }  

  public boolean find(String str) { 
    Node node = this.rootNode;
    for(int i=0; i<str.length(); i++) { 
      node = node.children.getOrDefault(str.charAt(i), null); 
      if(node == null) return false; 
    }      
    return node.endOfword; 
  }
}

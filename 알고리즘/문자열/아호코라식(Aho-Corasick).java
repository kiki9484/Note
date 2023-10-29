static class TrieNode{
	boolean endOfNode;
	Map<Character, TrieNode> child = new HashMap<>();
	TrieNode fail;
	public TrieNode() {}
	
	public void insert(String word) {
		TrieNode curNode = this;
		for(int i=0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			curNode.child.putIfAbsent(c, new TrieNode());
			curNode = curNode.child.get(c);
			
			if(i == word.length()-1) curNode.endOfNode = true;
		}
	}
		
	public void computeFailFunc() {
		Queue<TrieNode> queue = new LinkedList<>();
		this.fail = this;
		queue.add(this);
		
		while(!queue.isEmpty()) {
			TrieNode here = queue.poll();
			for(int i = 0; i < ALPABETS; i++) {
				char c = (char)(i+97);
				
				TrieNode next = here.child.get(c);
				if(next == null) continue;
				
				if(here == this) next.fail = this;
				else { 
					TrieNode failNode = here.fail;
					while(failNode != this && failNode.child.get(c) == null) 
						failNode = failNode.fail;
					if(failNode.child.get(c) != null)
						failNode = failNode.child.get(c);
					next.fail = failNode;
				}
				if(next.fail.endOfNode) next.endOfNode =true;
				queue.add(next);
			}
		}
	}
      
	public boolean find(String word) {
		TrieNode curNode = this;
		for(int i = 0; i<word.length(); i++) {
			char c = word.charAt(i);
			while(curNode != this && curNode.child.get(c) == null)
				curNode = curNode.fail;
			if(curNode.child.get(c) != null) 
				curNode = curNode.child.get(c);
			if(curNode.endOfNode) 
				return true;
		}
		return false;	
	}
}

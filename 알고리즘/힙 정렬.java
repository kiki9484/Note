static class MinHeap{
	List<Integer> nums = new ArrayList<>();

	public MinHeap(){}

	private void swap(int i, int j){
    int tmp = nums.get(i);
    nums.set(i, nums.get(j));
    nums.set(j, tmp);
	}

	public void add(int x){
    nums.add(x);
    int idx = nums.size() - 1;
    while(idx > 0 && nums.get((idx-1) / 2) > nums.get(idx)){
        swap(idx, (idx-1) / 2);
        idx = (idx-1) / 2;
    }
	}

	public int remove(){
    if(nums.size() == 0) return 0;
    int ret = nums.get(0);
    nums.set(0, nums.get(nums.size()-1));
    nums.remove(nums.size()-1);
    
    int here = 0;
    int next = here;
    while(true){
        if(2*here + 1 >= nums.size()) break;
        if(nums.get(here) > nums.get(2*here + 1)){
					next = 2*here + 1;
				}
        if(2*here + 2 < nums.size() && nums.get(next) > nums.get(2*here + 2)){
					next = 2*here + 2;
				}
        if(next == here) break;
        swap(here, next);
        here = next;
    }
    return ret;
	}  
}

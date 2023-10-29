public static void quickSort(int[] A, int low, int high){
	if(low < high){
		int pivotLoc = partition(A, low, high);
		quickSort(A, low, pivotLoc-1);
		quickSort(A, pivotLoc+1, high);
	}
}

public static int partition(int[] A, int low, int high){
	int randomLoc = ThreadLocalRandom.current().nextInt(high-low+1);
	swap(A, low, low+randomLoc);
	int p = A[low];
	int i = low+1;
	for(int j = low+1; j <= high; j++){
		if(A[j] < p){
			swap(A, i, j);
			i++;
		}
	}
	swap(A, low, i-1);
	return i-1;
}

public static void swap(int[] A, int i, int j){
	if(i == j) return;
	int tmp = A[i];
	A[i] = A[j];
	A[j] = tmp;
}

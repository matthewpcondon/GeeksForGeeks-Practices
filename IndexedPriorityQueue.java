class IndexedPriorityQueue {
	// uses a min heap, based on values and not keys
	int[] values; // for finding value, given key
	Integer[] pos_map; // for finding heap location, given key value
	Integer[] inverse_map; // for finding key, given heap location
	int n, heap_size;
	public IndexedPriorityQueue(int _n){
		values = new int[_n];
		Arrays.fill(values, Integer.MAX_VALUE);
		pos_map = new Integer[_n];
		inverse_map = new Integer[_n];
		n = _n;
		heap_size = 0;
	}/*
	public int[] getValues(){
		return values;
	} */
	public boolean empty(){
		return (heap_size == 0);
	}
	public boolean contains(int ki){
		return (pos_map[ki] != null);
	}
	public void insert(int ki, int val){
/*		if (heap_size >= n || ki >= n)
			return; */
		values[ki] = val;
		pos_map[ki] = heap_size; // new node inserted at end
		inverse_map[heap_size] = ki;
		swim(heap_size);
		++heap_size;
	}
	public int peekIndex(){
	    return inverse_map[0];
	}
	public int peekValue(){
		return values[inverse_map[0]];
	}
	public int poll(){
		// retrieve the key at the top of the heap.
		return remove(inverse_map[0]);
	}
	public int getValue(int ki){
		return values[ki];
	}
	public void update(int ki, int new_val){
		int heap_index = pos_map[ki];
		values[ki] = new_val;
		sink(heap_index);
		swim(heap_index);
	}
	private int remove(int ki){
		Integer heap_index = pos_map[ki];
		if (heap_index == null)
			throw new NullPointerException("ki is: " + ki);
		if (heap_index < 0 || heap_index >= n)
		    throw new ArrayIndexOutOfBoundsException("heap index is out of bounds.");
		swap(heap_index, heap_size-1);
		inverse_map[heap_size-1] = null;
		values[ki] = Integer.MAX_VALUE;
		pos_map[ki] = null;
		heap_size--;
		sink(heap_index);
		swim(heap_index);
		return ki;
	}
	private boolean less(int heap_index1, int heap_index2){
		if (heap_index1 >= n || heap_index2 >= n)
			throw new IndexOutOfBoundsException("heap index 1: "+
			heap_index1+"\nheap index 2: "+heap_index2);
		Integer k1 = inverse_map[heap_index1];
		Integer k2 = inverse_map[heap_index2];
		if (k1 == null || k2 == null || values[k1] == Integer.MAX_VALUE ||
		values[k2] == Integer.MAX_VALUE)
			throw new IndexOutOfBoundsException("k1: "+k1+"\nk2: "+k2+
			"\nk1 value: "+values[k1]+"\nk2 value: "+values[k2]);
		return values[k1] < values[k2];
	}
	private void swim(int i){ // i is the index to attempt to move up
		for (int parent = (i-1)/2; i > 0 && less(i, parent);){
				swap(i, parent);
				i = parent;
				parent = (i-1)/2;
		}
	}
	private void sink(int heap_index){
		while (true){
			int left = heap_index*2 + 1;
			int right = heap_index*2 + 2;
			int smallest = left;
			if (right < heap_size && less(right, left))
				smallest = right;
			if (left >= heap_size || less(heap_index, smallest))
				break;
			swap(heap_index, smallest);
			heap_index = smallest;
		}
	}
	private void swap(int heap_index1, int heap_index2){
		int k1 = inverse_map[heap_index1];
		int k2 = inverse_map[heap_index2];
		pos_map[k1] = heap_index2;
		pos_map[k2] = heap_index1;
		int temp = inverse_map[heap_index1];
		inverse_map[heap_index1] = inverse_map[heap_index2];
		inverse_map[heap_index2] = temp;
	}
}

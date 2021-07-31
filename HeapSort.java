//Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // the range of internal nodes is floor(n/2)-1 to 0.
        // an 'internal' node is one with children
        // a 'leaf' is a node that has no children.
        // this starts with internal nodes closes to the leaves
        int lastInternal = n/2 - 1;
        for (int i = lastInternal; i >= 0; i--){
            heapify(arr, n, i);
        }
    }
 
    //Heapify function to maintain heap property on per-node basis
    void heapify(int arr[], int n, int i)
    { // i is the node under whom the heap property is being maintained.
        // check which child is the highest, if any child is higher
        int l = 2*i+1;
        int r = 2*i+2;
        int greatest = i;
        if (l < n && arr[l] > arr[greatest]){
            greatest = l;
        }
        if (r < n && arr[r] > arr[greatest]){
            greatest = r;
        }
        if (greatest != i){
            //swap arr[i] and arr[largest]
            arr[i] ^= arr[greatest];
            arr[greatest] ^= arr[i];
            arr[i] ^= arr[greatest];
            // continue down the tree
            heapify(arr, n, greatest);
        }
    }
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        /*1. Build a max heap from the input data. 
        2. At this point, the largest item is stored at the root of the heap.
        swap it with the value at the end, then build heap
        3. Repeat step 2 while size of heap is greater than 1.
        */
        buildHeap(arr, n);
        while (n > 1){
            //swap the top and bottom
            arr[0] ^= arr[n-1];
            arr[n-1] ^= arr[0];
            arr[0] ^= arr[n-1];
            n--;
            heapify(arr, n, 0);
        }
    }

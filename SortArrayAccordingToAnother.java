public static int[] sortA1ByA2(int A1[], int n, int A2[], int m)
    {
        // traverse a1 and store frequency f of each element in a hashmap
        // initialize new array of size n.
        // Then, traverse a2 and check frequency. In order, insert each
        // element of a2 into new array f times.
        // Remove each key.
        // For each key remaining in the hashset
        Integer currCount;
        HashMap<Integer, Integer> frequencies =
            new HashMap<Integer, Integer>();
        // here we get the frequencies of each element
        for (int i : A1){
            if ( (currCount = frequencies.get(i)) != null ){
                currCount++; // since we found it already, increase the count
                frequencies.put(i, currCount);
            }
            else { // add to the map if not present
                frequencies.put(i, 1);
            }
        }
        int[] a3 = new int[n]; // we store the answer here
        int a3Itr = -1;
        for (int i : A2){
            if ( (currCount = frequencies.get(i)) != null ) {
                //System.out.println("The count found in a2 is: " + currCount);
                // fill a3 with the right number of copies
                while (currCount-- > 0){
                    a3[++a3Itr] = i;
                }// ensure we don't add it again when we fill the rest of a3
                frequencies.remove(i);
            }
        }
        // sort the rest of the array
        TreeMap<Integer, Integer> sorted = new TreeMap<>();
        sorted.putAll(frequencies);
        //System.out.println("Size of sorted is: " + sorted.size());
        for (Map.Entry<Integer, Integer> remaining : sorted.entrySet()){
            currCount = remaining.getValue();
		    while (currCount > 0){
		        //System.out.printf("n is: %d, a3Itr is: %d%n",
		        //n, a3Itr);
		        a3[++a3Itr] = remaining.getKey();
		        currCount--;
		    }
	    }
        return a3;
    }

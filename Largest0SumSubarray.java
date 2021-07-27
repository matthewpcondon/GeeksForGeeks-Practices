public int maxLen(int arr[], int n)
{
	HashMap<Integer, Integer> sumToIndex = new HashMap<Integer, Integer>();
	int sum = arr[0];
	sumToIndex.put(sum, 0);
	int max_len;
	if (sum == 0)
		max_len = 1;
	else
		max_len = 0;
	for (int i = 1; i < n; i++){
		sum += arr[i];
		if (sum == 0){
			max_len = i+1;
		}
		if (sumToIndex.containsKey(sum) ){
			// sums can't be mentioned twice in the map. We only need the first sum.
			max_len = Math.max(max_len, i - sumToIndex.get(sum));
			// if the sum is already found in the map, then the stretch of array
			// between i and where that sum was found sums to 0.
		}
		else {// sum is not found, so we add it to the map, in case we find that sum
		// later
			sumToIndex.put(sum, i);
		}
	}
	if (sum == 0){ // corner case where entire array sums to 0
		return n;
	}
	return max_len;
}

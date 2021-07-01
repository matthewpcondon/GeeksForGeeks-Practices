static int knapSack(int W, int wt[], int val[], int n) 
{ 
	int[][] mv = new int[n][W+1];/* max values, given a certain max weight
	to consider and a certain number of items to consider */
	int currentMaxValue, Wi, Vi;
	for (int r = 0; r < n; r++){
		for (int c = 0; c <= W; c++){
			Wi = wt[r]; // for code readability, I rename it the ith weight in the list.
			Vi = val[r];
			if (r == 0){
				currentMaxValue = (c < Wi ? 0 : Vi); /* one item in the bag, Wi
				has to be equal to or less than the max weight. */
				mv[r][c] = currentMaxValue;
			}
			else {
				if (c < Wi ) /* current item is too heavy, we can't include it, so we
				go with the weight that was calculated before */ {
					mv[r][c] = mv[r-1][c];
				}
				else {
					mv[r][c] = Math.max(Vi + mv[r-1][c-Wi], mv[r-1][c]); /* either include
					Wi or go with the value from not including it, whichever is higher */
				}
			}
		}
	}
	return mv[n-1][W];
}

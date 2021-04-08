class ComparatorPractice{
public static void main(String[] args)}{
	Scanner sc = new Scanner(System.in);
	string []s = new string[n+2];
	int n = sc.nextInt();
	for (int i = 0; i < n; i++){
		s[i] = sc.next();
	}
	Comparator<String> myComparator = new Comparator<String>(){
            @Override
            public int compare(String stringy1, String stringy2){
                BigDecimal bd1 = new BigDecimal(stringy1);
                BigDecimal bd2 = new BigDecimal(stringy2);
                return bd2.compareTo(bd1); // sort in descending order
            }
	};
	// create bigDecimal equivalents of each string in an array
	// use a comparator that compares each bigDecimal instead of each
	// string
	// sort the string array using the new comparator
        
	Arrays.sort(s, 0, n, myComparator);
}
}

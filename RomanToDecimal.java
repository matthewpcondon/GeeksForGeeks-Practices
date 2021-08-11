public int romanToDecimal(String input) {
        HashMap<Character, Integer> values =
            new HashMap<Character, Integer>(7);
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        
        char[] chars = input.toCharArray();
        int prevI = values.get(chars[0]);
        if (chars.length == 1)
        	return prevI;
        int len = chars.length;
        int ans = 0;
        for (int i = 1; i < len; i++){
            //System.out.println("prevI: "+prevI);
        	if (values.get(chars[i]) > prevI){ // we have a IV, or IX, or CD, or similar situation
        		prevI *= -1;
        	}
        	ans += prevI;
        	prevI = values.get(chars[i]);
        }
        //System.out.println("prevI: "+prevI);
        return ans + prevI;
    }

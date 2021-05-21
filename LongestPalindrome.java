private static int isPalindrome(char[] chars, int beg, int end){
        // returns 0 if it's not a palindrome, returns the length if so
        for (int i = beg, j = end; i <= j; i++, j--){
            if (chars[i] != chars[j]){
                return 0;
            }
        }
        return end - beg;
    }
    static String longestPalin(String S){
        // code here
        char[] chars = S.toCharArray();
        int len = S.length(), currLen = 0;
        // test each possible substring, O(n^2) time complexity
        // using nested loops
        int begAns = 0, endAns = 0, max = Integer.MIN_VALUE;
        for (int start = 0; start < len; start++){
            for (int end = start; end < len; end++){
                if ( ( currLen = isPalindrome(chars, start, end) ) > max ){
                    max = currLen;
                    begAns = start;
                    endAns = end;
                }
            }
        }
        return S.substring(begAns, endAns+1);
    }

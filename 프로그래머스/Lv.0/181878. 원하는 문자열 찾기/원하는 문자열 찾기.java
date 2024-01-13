class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        
        int i = myString.indexOf(pat);
        if(i>=0) return 1;
        return 0;
    }
}
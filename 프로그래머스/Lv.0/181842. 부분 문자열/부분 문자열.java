class Solution {
    public int solution(String str1, String str2) {
        int i = str2.indexOf(str1);
        if(i>=0) return 1;
        return 0;
    }
}
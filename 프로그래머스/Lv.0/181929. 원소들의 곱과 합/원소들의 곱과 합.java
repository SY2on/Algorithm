class Solution {
    public int solution(int[] num_list) {
        int mul = 1;
        int sum = 0;
        for(int n : num_list){
            mul*=n;
            sum+=n;
        }
        if(mul<sum*sum) return 1;
        return 0;
    }
}
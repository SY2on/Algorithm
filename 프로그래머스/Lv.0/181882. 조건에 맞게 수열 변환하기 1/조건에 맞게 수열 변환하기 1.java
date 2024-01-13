class Solution {
    public int[] solution(int[] arr) {
       for(int i=0; i<arr.length; i++){
           int n = arr[i];
           if(n%2==0&&n>=50) arr[i] = n/2;
           if(n%2==1&&n<50) arr[i] = 2*n;
       } 
        return arr;
    }
}
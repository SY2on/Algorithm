import java.util.Scanner;

public class Main {
    static int n;
    static long[] arr;
    static long[] arrcopy;
    static long count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new long[n];
        arrcopy = new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i] =sc.nextInt();
        }

        count =0;
        Merge(0,n-1);

        System.out.println(count);
    }

    private static void Merge(int left, int right){
        if(left != right){
            int mid =(left+right)/2;
            Merge(left, mid);
            Merge(mid+1, right);
            MergeSort(left,right);
        }
    }

    private static  void MergeSort(int left , int right){
        int mid =(left+right)/2;
        int i  = left;
        int j =  mid + 1;
        int k = left;

    
        while(i <= mid && j<=right){
            
            if(arr[i] > arr[j]){ 
                arrcopy[k++]=arr[j++];
                count+= mid-i+1;
            }else {
          
                arrcopy[k++] =  arr[i++];
            }
        }

        if(i>mid){ 
            while(j<=right){
                arrcopy[k++] = arr[j++];
            }
        }else{
            while(i<=mid){
                arrcopy[k++] = arr[i++];
            }
        }

        for (int h = left; h <= right ; h++) {
            arr[h] = arrcopy[h];
        }


    }


}

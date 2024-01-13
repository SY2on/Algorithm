import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] cArray = a.toCharArray();
        for(int i=0; i<a.length(); i++){
            if(Character.isUpperCase(cArray[i])) cArray[i] = Character.toLowerCase(cArray[i]);
            else cArray[i] = Character.toUpperCase(cArray[i]);
        }
        System.out.print(String.valueOf(cArray));
    }
}
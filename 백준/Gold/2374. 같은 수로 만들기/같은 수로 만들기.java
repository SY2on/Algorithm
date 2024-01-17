import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int n;
    static int max = 0;
    static int[] nums;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()) {

            }else if(stack.peek() <= nums[i]) {
                count += nums[i]-stack.pop();
            }else{
                stack.pop();
            }
            stack.push(nums[i]);
        }
            count+= max-stack.pop();

        System.out.println(count);

    }

}

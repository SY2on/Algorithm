import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int result =0;
    static int height =0; //최고 높이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack.push(0);
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if(height<y){
                height = y;
                stack.push(y);
            }else if(height>y){
                height =y;
                while(stack.peek()>height){
                    stack.pop();
                    result++;
                }
                if(stack.peek()<height){
                    stack.push(height);
                }
            }
        }
        while(stack.peek()!=0){
            stack.pop();
            result++;
        }

        System.out.println(result);
    }
}

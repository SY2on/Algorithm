import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;
            if (isRight(input)) {
                bw.write("yes\n");
            } else bw.write("no\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isRight(String input) {
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c=='('||c=='['){
                stack.push(c);
            } else if(c==')'){
                if(stack.isEmpty()||stack.pop()!='(') return false;
            }else if(c==']'){
                if(stack.isEmpty()||stack.pop()!='[') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

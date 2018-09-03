package parent.prac15;

import java.util.Stack;

public class prac15 {
    private static final String exp = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        char[] expArray = exp.toCharArray();
        for (int i = 0; i < expArray.length; i++) {
            if (expArray[i] == '+') {
                stack.push(expArray[i + 1]);
            }
            else if (expArray[i] == '-') {
                System.out.println(stack.peek());
                stack.pop();
            }
        }

    }
}

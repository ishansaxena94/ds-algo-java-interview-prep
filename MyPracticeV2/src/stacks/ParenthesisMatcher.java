package stacks;

import java.util.Stack;

public class ParenthesisMatcher
{
    static boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Stack<Character> stack = new Stack<>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);

            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening bracket, then it must be closing.
            // So stack cannot be empty at this point.
            if (stack.isEmpty())
                return false;

            char check = stack.pop();
            switch (x) {
                case ')':
                    if (check != '(')
                        return false;
                    break;

                case '}':
                    if (check != '{')
                        return false;
                    break;

                case ']':
                    if (check != '[')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }

    public static void main(String[] args)
    {
        String expr = "([{}])";
        String expr2 = "(([))";
        String expr3 = "(())}";
        String expr4 = "(){}[]";
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");

        System.out.println(areBracketsBalanced(expr2));
        System.out.println(areBracketsBalanced(expr3));
        System.out.println(areBracketsBalanced(expr4));

    }
}

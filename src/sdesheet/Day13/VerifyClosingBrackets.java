package sdesheet.Day13;

import java.util.*;

public class VerifyClosingBrackets {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        
        if (len % 2 != 0)
            return false;
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty()) {
                char peek = stack.peek();
                if ((c == ')' && peek == '(') || (c == ']' && peek == '[') || (c == '}' && peek == '{'))
                    stack.pop();
                else if (c == '(' || c == '{' || c == '[')
                    stack.push(c);
                else
                    return false;
            }
            else {
                if (c == ')' || c == '}' || c == ']')
                    return false;
                else
                    stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
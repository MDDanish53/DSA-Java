import java.util.Stack;

class ValidParentheses {
  public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }

    void main() {
      String s = "[{[](){}}]";
      System.out.println(isValid(s));
    }
}
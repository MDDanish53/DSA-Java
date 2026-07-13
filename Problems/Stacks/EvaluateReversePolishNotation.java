import java.util.Stack;

class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    String operators = "+-*/";

    for (String token : tokens) {
      if (operators.indexOf(token) != -1) {
        int d2 = stack.pop();
        int d1 = stack.pop();
        int res = 0;
        int operator = operators.indexOf(token);
        switch (operator) {
          case 0: {
            res = d1 + d2;
            break;
          }
          case 1: {
            res = d1 - d2;
            break;
          }
          case 2: {
            res = d1 * d2;
            break;
          }
          case 3: {
            res = d1 / d2;
            break;
          }
        }
        stack.push(res);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return stack.peek();
  }
}
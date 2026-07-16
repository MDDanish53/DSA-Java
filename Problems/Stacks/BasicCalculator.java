import java.util.Stack;

class Pair {
  private long sum;
  private int sign;

  public Pair(long sum, int sign) {
    this.sum = sum;
    this.sign = sign;
  }

  public long getSum() {
    return this.sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }

  public int getSign() {
    return this.sign;
  }

  public void setSign(int sign) {
    this.sign = sign;
  }
}

class BasicCalculator {
  public int calculate(String s) {
    long sum = 0;
    int sign = 1;

    // declare stack to store <prev expn value, sign before open bracket>
    Stack<Pair> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {

      // check if it is digit
      if (Character.isDigit(s.charAt(i))) {

        // find the num
        int digit = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          digit = digit * 10 + (s.charAt(i) - '0');
          i++;
        }
        // decrement to come to the last digit
        i--;

        // add value to the sum
        sum += (digit * sign);
        sign = 1; // reset sign

        // opening brackets (save the <prev. expn. value, along with sign> in stack)
      } else if (s.charAt(i) == '(') {
        // save current state of(sum, sign) in stack
        stack.push(new Pair(sum, sign));

        // for inner bracket calculation, reset sum and sign
        sum = 0;
        sign = 1;
      }

      // closing bracket (add value to the sum along with its sign)
      else if (s.charAt(i) == ')') {
        sum = stack.peek().getSum() + (stack.peek().getSign() * sum);
        stack.pop();
      }

      // '-' symbol (change the sign i.e toggle)
      else if (s.charAt(i) == '-') {
        // Just change the sign. to -ve or +ve
        sign = -1 * sign;
      }
    }

    return (int) sum;
  }
}
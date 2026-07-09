/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack; // to track the min value

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        // check if the minStack is empty or the top value of minStack is greater than value
        if(minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
    }
    
    public void pop() {
            int poppedValue = stack.pop();
            // if poppedValue == minStack.peek()
            // if they are same then pop from the minStack too
            if(poppedValue == minStack.peek()) {
                minStack.pop();
            }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

class Testing {
  public static void main(String args[]) {
      MinStack stack = new MinStack();
      stack.push(1);
      stack.push(2);
      stack.pop();
      stack.push(4);
      stack.push(-1);
      stack.push(5);
      System.out.println(stack.getMin());
  }
}

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// class ImplementQueueUsingStack {
// Stack<Integer> stack1;
// Stack<Integer> stack2;

// public ImplementQueueUsingStack() {
// stack1 = new Stack<>();
// stack2 = new Stack<>();
// }

// public void push(int x) {
// while(!stack2.empty()) {
// stack1.push(stack2.pop());
// }
// stack2.push(x);
// while(!stack1.empty()) {
// stack2.push(stack1.pop());
// }
// }

// public int pop() {
// return stack2.pop();
// }

// public int peek() {
// return stack2.peek();
// }

// public boolean empty() {
// return stack2.empty();
// }
// }

// optimized code
class ImplementQueueUsingStack {
  Stack<Integer> stack1;
  Stack<Integer> stack2;

  public ImplementQueueUsingStack() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    peek();
    return stack2.pop();
  }

  public int peek() {
    if (stack2.empty()) {
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.peek();
  }

  public boolean empty() {
    return stack1.empty() && stack2.empty();
  }
}
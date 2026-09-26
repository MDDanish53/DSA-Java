
import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // left smaller nearest
        int[] right = new int[n]; // right smaller nearest
        Stack<Integer> stack = new Stack<>();

        // right smaller
        for(int i = n-1; i >= 0; i--) {
            while(stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? n : stack.peek();
            stack.push(i);
        }

        // empty the stack
        while(!stack.empty()) {
            stack.pop();
        }

        // left smaller
        for(int i = 0; i < n; i++) {
            while(stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? -1  : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            ans = Math.max(ans, area);
        }

        return ans;
    }
}
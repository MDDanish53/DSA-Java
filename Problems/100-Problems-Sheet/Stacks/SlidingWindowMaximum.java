
import java.util.ArrayDeque;

class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {

    // Result array ka size = total windows
    int[] res = new int[nums.length - k + 1];
    int j = 0;

    // Deque me indices store honge (values nahi)
    // Hamesha decreasing order me elements maintain karega
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {

      // Chhote elements ko peeche se hata do,
      // kyunki current element unse bada hai aur future me unki zarurat nahi padegi.
      while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
        queue.removeLast();
      }

      // Current index ko deque ke end me add karo
      queue.addLast(i);

      // Agar deque ka first index current window ke bahar chala gaya hai,
      // to usse remove kar do.
      if (queue.getFirst() + k == i) {
        queue.removeFirst();
      }

      // Jab first window complete ho jaye (i >= k-1),
      // to deque ka first element hi maximum hoga.
      if (i >= k - 1) {
        res[j++] = nums[queue.getFirst()];
      }
    }

    return res;
  }
}
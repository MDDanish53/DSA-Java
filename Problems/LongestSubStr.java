
import java.util.ArrayList;
import java.util.List;

// Longest Substring Without Repeating Characters
class LongestSubStr {

  public int lengthOfLongestSubstring(String str) {
    int start = 0;
    int end = 0;
    int max_length = 0;
    List<Character> list = new ArrayList<>();

    // pwwkew
    //str length = 6;
    // start = 1;
    // end = 4;
    // max_l = 2;
    //list = {p,w,k};
      
    while(end < str.length()) {
      if(!list.contains(str.charAt(end))) {
        list.add(str.charAt(end));
        end++;
        max_length = Math.max(max_length, list.size());
      } else {
        list.remove(Character.valueOf(str.charAt(start)));
        start++;
      }
    }
    return max_length;

  }

  void main() {
    String str = "pwwkew";
    System.out.println(lengthOfLongestSubstring(str));
  }
}
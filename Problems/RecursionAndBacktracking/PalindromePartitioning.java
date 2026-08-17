import java.util.List;
import java.util.ArrayList;

class PalindromePartitioning {

  List<List<String>> res = new ArrayList<>();

  public List<List<String>> partition(String s) {
    recur(s, 0, new ArrayList<>());
    return res;
  }

  public boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  public void recur(String s, int partIndex, List<String> sublist) {
    // base case
    if (partIndex == s.length()) {
      res.add(new ArrayList<>(sublist));
      return;
    }

    // explore the possibilities
    for (int end = partIndex; end < s.length(); end++) {
      if (isPalindrome(s, partIndex, end)) {
        // add in list
        sublist.add(s.substring(partIndex, end + 1)); // need to include end so end+1
        // explore further
        recur(s, end + 1, sublist);
        // backtrack
        sublist.remove(sublist.size() - 1);
      }
    }
  }
}
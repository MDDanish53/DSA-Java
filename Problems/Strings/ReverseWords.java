package Strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {

  // brute force approach
  public String reverseString(String s) {
    s = s.trim();
    String[] words = s.split(" ");
    List<String> wordsList = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      if(words[i].length() >= 1) {
        wordsList.add(words[i]);
      }
    }
    int start = 0;
    int end = wordsList.size() - 1;
    while (start <= end) {
      String st = wordsList.get(start);
      String ed = wordsList.get(end);
      wordsList.set(start, ed);
      wordsList.set(end, st);
      start++;
      end--;
    }
    String result = String.join(" ", wordsList);
    return result;
  }

  // optimized approach
  public String revString(String s) {
    // 1. split the string into words
    String words[] = s.split(" +");

    // 2. reverse the array 
    StringBuilder sb = new StringBuilder();
    for(int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i]);
      sb.append(" ");
    }
    // return the sb by converting it into string and remove the leading and trailing spaces
    return sb.toString().trim();
  }

  void main() {
    String s = "a good   example";
    System.out.println(revString(s));
  }
}

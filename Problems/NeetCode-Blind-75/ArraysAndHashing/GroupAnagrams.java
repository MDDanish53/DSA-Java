import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List> map = new HashMap<>();

    for (String str : strs) {
      // Calculate the frequency of characters
      int[] frequency = new int[26];
      for (char c : str.toCharArray()) {
        frequency[c - 'a']++;
      }
      // Convert the frequency array to string to use as key (creating a hash)
      StringBuilder sb = new StringBuilder();
      for (int i : frequency) {
        sb.append("#");
        sb.append(i);
      }
      String key = sb.toString();
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<String>());
      }
      // Add the string to the list of its anagram group
      map.get(key).add(str);
    }
    return new ArrayList(map.values());
  }
}
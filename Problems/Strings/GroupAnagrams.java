package Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {

  public String getStringFrequency(String str) {
    int[] freq = new int[26];

    for(char ch : str.toCharArray()) {
      freq[ch - 'a']++;
    }

    StringBuilder frequencyString = new StringBuilder("");

    char ch = 'a';
    for(int count : freq) {
      frequencyString.append(ch);
      frequencyString.append(count);
    }

    return frequencyString.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    if(strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> frequencyStringsMap = new HashMap<>();

    for(String str : strs) {
      String stringFreq = getStringFrequency(str);

      // if the frequency string is present, add the string to the list
      if(frequencyStringsMap.containsKey(stringFreq)) {
        frequencyStringsMap.get(stringFreq).add(str);
      } else {
        // else create a new list
        List<String> strList = new ArrayList<>();
        strList.add(str);
        frequencyStringsMap.put(stringFreq, strList);
      }
    }

    return new ArrayList<>(frequencyStringsMap.values());

  }

  void main() {
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    List<List<String>> ans = groupAnagrams(strs);
    System.out.println(ans);
  }
}
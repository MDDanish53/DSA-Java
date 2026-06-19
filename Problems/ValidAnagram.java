import java.util.Arrays;

class ValidAnagram {

  public boolean validAnagram1(String s, String t) {

      if(s.length() != t.length() || s.length() == 0 || t.length() == 0) {
        return false;
      } else {
      Character arr1[] = new Character[s.length()];
      Character arr2[] = new Character[t.length()];
      for(int i = 0; i < s.length(); i++) {
        arr1[i] = s.charAt(i);
        arr2[i] = t.charAt(i);
      }
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      
      s = Arrays.toString(arr1);
      t = Arrays.toString(arr2);
      if(s.equals(t)) {
        return true;
      }
      }
      return false;
  }

  public boolean validAnagram2(String s, String t) {
    if(s.length() != t.length() || s.length() == 0 || t.length() == 0) {
      return false;
    }

    char[] arr1 = s.toCharArray();
    char[] arr2 = t.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    s = Arrays.toString(arr1);
    t = Arrays.toString(arr2);
    return s.equals(t);
  }
 
  // optimized one
  public boolean validAnagram(String s, String t) {
    if(s.length() != t.length()) return false;
    
    // array to store the count of each alphabet occurance in the array
    int count[] = new int[26];
    
    // increasing the count of alphabet in String s in count[]
    for(int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }

    // decreasing the count of alphabet in String t in count[]
    for(int i = 0; i < t.length(); i++) {
      count[t.charAt(i) - 'a']--;
    }

    // if any character's index value in count[] is greater than zero means both the strings are not anagrams of each other
    for(int i = 0; i < count.length; i++) {
      if(count[i] != 0) {
        return false;
      }
    }
    return true;
  }
 
  void main() {
    String s = "anagram";
    String t = "nagaram";
    System.out.println(validAnagram1(s, t));
  }
}
class LongestPalindrome {

  public String reverse(char[] str, int start, int end) {
    while (start <= end) {
      char temp = str[start];
      str[start] = str[end];
      str[end] = temp;
      start++;
      end--;
    }
    return str.toString();
  }

  public String longestPalindrome(String str) {
    if (str.length() <= 1) {
      return str;
    }

    String LPS = "";
    // low = 0, high = 2
    // babad => Lps = a

    // i = 2 => low = 1, high = 2
    // babad => Lps = aba

    // i = 3 => low = 2, high = 4
    // babad => Lps = aba

    // i = 4 => low = 3, high = 4
    // babad => Lps = aba

    for (int i = 1; i < str.length(); i++) {

      // Consider odd length
      int low = i;
      int high = i;
      // keep extending in both left and right directions till the conditions for a
      // palindrome are met
      while (str.charAt(low) == str.charAt(high)) {
        low--;
        high++;

        // terminate condition if we reach the end/start of the string
        if (low == -1 || high == str.length()) {
          break;
        }
      }

      // Indexes low and high can be used to extract sub-string
      String palindrome = str.substring(low + 1, high);
      if (palindrome.length() > LPS.length()) {
        // Capture the longest palindrome found
        LPS = palindrome;
      }

      // Consider even length
      low = i - 1;
      high = i;
      while (str.charAt(low) == str.charAt(high)) {
        low--;
        high++;

        if (low == -1 || high == str.length()) {
          break;
        }
      }

      palindrome = str.substring(low + 1, high);
      if (palindrome.length() > LPS.length()) {
        // Similarly, keep a track of the longest even length palindrome
        LPS = palindrome;
      }
    }
    return LPS;
  }

  void main() {
    String s = "cbbd`";
    System.out.println(longestPalindrome(s));
  }
}
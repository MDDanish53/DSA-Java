class CountAndSay {

  public String countAndSay(int n) {
    if (n == 1)
      return "1";
    if (n == 2)
      return "11";
    String ans = "11";
    for (int i = 3; i <= n; i++) {
      String temp = "";
      ans += "&";
      int count = 1;
      for (int j = 1; j < ans.length(); j++) {
        if (ans.charAt(j) != ans.charAt(j - 1)) {
          temp += Integer.toString(count);
          temp += ans.charAt(j - 1);
          count = 1;
        } else {
          count++;
        }
      }
      ans = temp;
    }
    return ans;
  }

  void main() {
    int n = 3;
    System.out.println(countAndSay(n));
  }
}
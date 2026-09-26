import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfPhoneNo {
  public void getCombination(String digits, int index, StringBuilder output, List<String> res, String[] mapping) {

    // base case - if index is greater than or equal to digits.length() then add the
    // output in res and return
    if (index >= digits.length()) {
      res.add(output.toString());
      return;
    }

    // get the current digit
    int digit = digits.charAt(index) - '0';
    // get corresponding letters of the digit
    String letters = mapping[digit];

    // loop through each letter and add it first and go to next digit recursively,
    // and remove the current added letter while backtracking
    for (int i = 0; i < letters.length(); i++) {
      output.append(letters.charAt(i));
      getCombination(digits, index + 1, output, res, mapping);
      output.deleteCharAt(output.length() - 1);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    StringBuilder output = new StringBuilder("");
    int index = 0;
    String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    getCombination(digits, index, output, res, mapping);
    return res;
  }
}
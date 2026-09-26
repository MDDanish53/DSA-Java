import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CombinationSum {

  Set<List<Integer>> uniqueCombinations = new HashSet<>();

  public void getAllCombinations(int[] candidates, int index, int target, List<List<Integer>> ans,
      List<Integer> combination) {
    if (index == candidates.length || target < 0) {
      return;
    }

    if (target == 0) {
      if (!uniqueCombinations.contains(combination)) {
        uniqueCombinations.add(combination);
        ans.add(new ArrayList<>(combination));
        return;
      }
    }

    combination.add(candidates[index]);

    // not include the current included candidate
    getAllCombinations(candidates, index + 1, target - combination.get(combination.size() - 1), ans, combination);

    // include the current included candidate again
    getAllCombinations(candidates, index, target - combination.get(combination.size() - 1), ans, combination);

    // not include the current candidate and move for further candidates
    combination.remove(combination.size() - 1);
    getAllCombinations(candidates, index + 1, target, ans, combination);
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();
    getAllCombinations(candidates, 0, target, ans, combination);
    return ans;
  }
}
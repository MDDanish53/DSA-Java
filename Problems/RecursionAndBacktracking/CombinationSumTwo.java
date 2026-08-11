
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumTwo {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> subsets = new ArrayList<>();
    generateSubsets(0, candidates, new ArrayList<>(), subsets, target);
    return subsets;
  }

  public void generateSubsets(int index, int[] candidates, List<Integer> current, List<List<Integer>> subsets,
      int target) {
    if (target == 0) {
      subsets.add(new ArrayList<>(current));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (i > index && candidates[i] == candidates[i - 1])
        continue;
      current.add(candidates[i]);
      generateSubsets(i + 1, candidates, current, subsets, target - candidates[i]);
      current.remove(current.size() - 1);
    }
  }
}
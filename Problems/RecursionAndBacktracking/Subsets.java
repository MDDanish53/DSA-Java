import java.util.ArrayList;
import java.util.List;

class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    public void findSubsets(int[] nums, int index, List<Integer> sublist) {
        // base case
        if (index == nums.length) {
            res.add(new ArrayList<>(sublist));
            return;
        }

        // pick case
        sublist.add(nums[index]);
        findSubsets(nums, index + 1, sublist);

        // while backtracking, we need to remove the last added element
        sublist.remove(sublist.size() - 1);

        // no pick case
        findSubsets(nums, index + 1, sublist);
        // since we have not added any element so no need to remove anything while backtracking
    }
}
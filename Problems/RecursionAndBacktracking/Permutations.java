
import java.util.ArrayList;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        backtrack(resultList, new ArrayList<>(), nums);
        return resultList; 

    }

    public void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums) {

        if(tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }

        for(int num : nums) {
            if(tempList.contains(num)) {
                continue;
            }

            tempList.add(num);

            backtrack(resultList, tempList, nums);

            tempList.remove(tempList.size() - 1);

        }

    }
}
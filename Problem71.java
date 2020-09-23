//Time Complexity: O(n*2^n)
//Space Complexity: O(n*2^n)
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.*;
public class Problem71 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(output, nums, path, 0);
        return output;
    }

    private void backtrack(List<List<Integer>> output, int[] nums, List<Integer> path, int index){
        //base case
        if(index>=nums.length){
            output.add(new ArrayList<>(path));
            return;
        }


        output.add(new ArrayList<>(path));

        //recursive
        for(int i=index; i<nums.length; i++){
            path.add(nums[i]);
            backtrack(output, nums, path, i+1);
            path.remove(path.size() - 1);
        }
    }
}

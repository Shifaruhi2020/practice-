// solution link : https://www.youtube.com/watch?v=7jDS9KQEDbI
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> value_index = new HashMap<>();
        int[] ans = new int[2];
        for (int i =0; i < nums.length ; i ++){
            int val = target - nums[i];
            if(value_index.containsKey(val)){
                return new int[] {value_index.get(val), i};
            }
            value_index.put(nums[i], i);
        } 
        return new int[] {};
    }
}

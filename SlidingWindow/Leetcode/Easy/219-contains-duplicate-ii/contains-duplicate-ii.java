// Solution Link: https://www.youtube.com/watch?v=1Vl4UCI7FXs
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> window = new HashMap<>();
        for (int i =0; i < nums.length; i ++){
            if(window.containsKey(nums[i])){
                int getOldIdx = window.get(nums[i]);
                if((i - getOldIdx) <= k ){
                    return true;
                }else{window.put(nums[i],i);
                }
            }else{
                window.put(nums[i], i);
            }
        }
        return false;
    }
}
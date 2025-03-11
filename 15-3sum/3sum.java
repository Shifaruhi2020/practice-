class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if(nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i< nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[right] + nums[left];

                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums [right]));
                    left++;
                    right--;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }  
        return new ArrayList<>(ans); 
    }
}
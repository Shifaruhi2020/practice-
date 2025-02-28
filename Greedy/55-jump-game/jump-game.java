class Solution {
    public boolean canJump(int[] nums) {
        int final_position = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if(i + nums[i] >= final_position){
                final_position = i;
            }  
        }

            return final_position == 0;  
        
    }
}
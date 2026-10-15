// solution link : https://www.youtube.com/watch?v=XnMdNUkX6VM
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);   
    }

    public int atMost(int[] nums, int goal) {

         if(goal< 0){
            return 0;
        }

        int left = 0;
        int sum = 0;
        int cnt = 0;
        int right = 0;
        
        while( right < nums.length){

            sum += nums[right];

            while(sum > goal){
                sum = sum - nums[left];
                left++;
            }

            cnt = cnt + (right - left + 1);

            right++;
        }

        return cnt;
    }
}
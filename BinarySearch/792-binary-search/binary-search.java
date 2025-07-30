class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
       
    //    nums = [5], target = 5
    // in this case if we do left < right instead of left<= right
    // then returns -1 instead of 0
    // left <= right -> this condition helps with, single item array
        while(left <= right){
            int mid = left+ (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1; 
    }
}
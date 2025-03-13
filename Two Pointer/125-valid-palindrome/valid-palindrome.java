class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int right = s.length() - 1;
        int left = 0;

        while(left < right){

            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);

            if(!(ch1 >= 'a' && ch1 <='z' || ch1 >= '0' && ch1 <='9')){
                left++;
                continue;
            }

            if(!(ch2 >= 'a' && ch2 <='z' || ch2 >= '0' && ch2 <='9')){
                right--;
                continue;
            }
            if(ch1 != ch2){
                return false;
        }
        left++;
        right--;
        }
        return true;  
    }   
}
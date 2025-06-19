// for solution : https://www.youtube.com/watch?v=-zSxTJkcdAo

// Note: optimal solution is using the sliding window(kind of a 2 pointer    
// approach)
// with memory (HashMap) (S.W + HashMap)
// vid has only the approach and nt the code (coded on my own with chatGpt)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        int maxLength = 0; 

        for(int r = 0 ; r < s.length() ; r ++){
            char curChar = s.charAt(r);
            // first condtion : map.containsKey(curChar)
            // checks if the char is in map already
            // second condtion : && map.get(curChar)
            // makes sure that the l starts from the window we are
            // are checking in and doesnt allow l to update to any 
            // other value  which is before the window we are present in 
            if(map.containsKey(curChar) && map.get(curChar) >= l ){
                l = map.get(curChar) + 1;
            }
            map.put(curChar, r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
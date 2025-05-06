
// solution link: https://www.youtube.com/watch?v=IRN1VcA8CGc
class Solution {
    public boolean isAnagram(String s, String t) {
        
    int[] char_count = new int[26];

        if(s.length() == t.length()){
                   for(int i = 0; i < s.length(); i++ ){
            char_count[s.charAt(i) - 'a']++;
            char_count[t.charAt(i) - 'a']--;
        }

        for(int count:char_count){
            if(count != 0){
                return false;
            }
        }
        return true;
        }
        else{
            return false;
        }
    }
}
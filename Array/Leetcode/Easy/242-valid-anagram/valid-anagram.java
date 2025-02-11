import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        
        String str1 = s.toLowerCase();
        String str2 = t.toLowerCase();

        str1 = str1.replace(" ","");
        str2 = str2.replace(" ","");
        
        int[] counts = new int[26];

        for (int i =0; i < str1.length(); i ++){
            counts[str1.charAt(i) - 'a']++ ;
        }

        for (int i =0; i < str2.length(); i ++){
            counts[str2.charAt(i) - 'a']-- ;
        }

        for(int count : counts){
            if(count != 0) 
                return false; 
        }  
        return true;  
    }
}
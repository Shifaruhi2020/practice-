class Solution {
    public int numberOfSubstrings(String s) {

        int left = 0;
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char cur = s.charAt(right);

            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while(map.size() == 3){

                count += s.length() - right ;

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return count;
    }
}
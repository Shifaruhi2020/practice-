class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxfreq = 0;
        int maxlen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char charAtright = s.charAt(right);

            map.put(charAtright, map.getOrDefault(charAtright, 0) + 1);

            maxfreq = Math.max(maxfreq, map.get(charAtright));

            while((right - left + 1) - maxfreq > k){

                char charAtleft = s.charAt(left);
                map.put(charAtleft, map.get(charAtleft) - 1);

                if(map.get(charAtleft) == 0){
                    map.remove(charAtleft);
                }

                left++;

            }

            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
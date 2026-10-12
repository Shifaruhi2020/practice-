// solution link : https://www.youtube.com/watch?si=Kh0_u6aCkkBU3Q33&v=teM9ZsVRQyc&feature=youtu.be
class Solution {
    public int kDistinctChar(String s, int k) {

        int left = 0;
        int maxlen = 0;
        int number = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char c = s.charAt(right);

            if(!map.containsKey(c)){
                number++;
            }

            map.put(c, map.getOrDefault(c, 0) + 1);

            while(number > k){

                char charAtLeft = s.charAt(left);

                map.put(charAtLeft, map.get(charAtLeft) - 1);

                if(map.get(charAtLeft) == 0){
                    map.remove(charAtLeft);
                    number--;
                }

                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}

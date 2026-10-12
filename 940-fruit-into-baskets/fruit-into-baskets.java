// solution link : https://www.youtube.com/watch?v=e3bs0uA1NhQ
class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxlen = 0;
        int count = 0;

        HashMap<Integer, Integer> type = new HashMap<>();

        for(int right =0; right < fruits.length; right++){

            type.put(fruits[right], type.getOrDefault(fruits[right], 0) + 1);

            while(type.size() > 2){

                int fruit = fruits[left];

                type.put(fruit, type.get(fruit) - 1);

                if(type.get(fruit) == 0){
                    type.remove(fruit);
                }
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
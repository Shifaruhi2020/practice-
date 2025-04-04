// Solution Link : https://www.youtube.com/watch?v=C9V66KyZCP8
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null && strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String> > freqMap = new HashMap<>();
        for(String str : strs){
            String freqString = getFreqString(str);

            if(freqMap.containsKey(freqString)){
                freqMap.get(freqString).add(str);
            }
            else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                freqMap.put(freqString,newList);
            } 
        }
        return new ArrayList<>(freqMap.values());  
    }

    private String getFreqString(String str){
        int[] freq = new int[26];
        for (char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        StringBuilder newFreqString = new StringBuilder("");
        // System.out.println(newFreqString instanceof StringBuilder);
        char c = 'a';
        for(int i : freq){
            newFreqString.append(c);
            newFreqString.append(i);
            c++;
        }
        return newFreqString.toString();
    }

}

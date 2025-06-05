class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character , Integer> mapForS = new HashMap<>();

        for(int i = 0; i < s.length(); i ++){
            char chS = s.charAt(i);
            if(mapForS.containsKey(chS)){
                mapForS.put(chS, mapForS.get(chS) + 1);
            }
            else{
                mapForS.put(chS, 1);
            } 
        }

        HashMap<Character , Integer> mapForT = new HashMap<>();

        for(int i = 0; i < t.length(); i ++){
            char chT = t.charAt(i);
            if(mapForT.containsKey(chT)){
                mapForT.put(chT , mapForT.get(chT) + 1 );
            }
            else{
                mapForT.put(chT, 1);
            }      
        }
        return mapForS.equals(mapForT);
    }
}
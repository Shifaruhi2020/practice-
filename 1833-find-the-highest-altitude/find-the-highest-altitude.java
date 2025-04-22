import java.util.*;
class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;

        for(int i = 1 ; i <= gain.length; i ++){
            altitude[i] = altitude[i - 1] + gain[i -1];
        }
        // 6
        // 1 = 0 + -5 = -5 
        // 2 = -5 + 1 = -4
        // 3 = -4 + 5 = 1
        // 4 = 1 + 0 = 1
        // 5 = 1 + -7 = -6
        System.out.println(Arrays.toString(altitude));
        Arrays.sort(altitude);
        return altitude[altitude.length - 1];
        
    }
}
import java.util.*;

class Solution {
    public String solution(String s) {
        String[] n = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String nStr : n ){
            int number = Integer.parseInt(nStr);
            if(number < min) min = number;
            if(number > max) max = number;
        }
        return min + " " + max;
       
    }
}
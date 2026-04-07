class Solution {
    boolean solution(String s) {
        int cnt = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt == -1) {
                break;
            }
        }
        
        return cnt == 0;
    }
}
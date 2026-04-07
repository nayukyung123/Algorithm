class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] letters = s.toLowerCase().split("");
        boolean isFirst = true;
        for (String letter : letters) {
            
            if(isFirst){
                answer += letter.toUpperCase();
            }else {
                answer += letter;
            }
            
            if (letter.equals(" ")){
                isFirst = true;
            }else{
                isFirst = false;
            }
        }
        return answer;
    }
}

// 전부 소문자 
// 첫 글자 깃발 
// 한 글자 씩 검사 : 만약 공백이라면 공백이 아니라면 
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // 정렬 
        Arrays.sort(A);
        Arrays.sort(B);

        // 극과 극 
        for (int i = 0; i < A.length; i++){
            
            int a = A[i];
            
            int b = B[B.length -1 -i];
            
            answer += (a * b);

        }

        return answer;
    }
}
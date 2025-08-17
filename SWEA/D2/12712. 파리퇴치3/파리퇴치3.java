import java.util.*;
import java.io.*;
public class Solution {
    //가로, 세로 방향
    static int [] dr1 = {-1, 1, 0, 0};
    static int [] dc1 = {0, 0, -1, 1};
     
    //대각선 방향
    static int [] dr2 = {-1, -1, 1, 1};
    static int [] dc2 = {-1, 1, -1, 1};
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int t = sc.nextInt();
        //테스트케이스 시작
        for(int tc=1; tc<=t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
             
            //새로운 배열 생성
            int [][] arr = new int [n][n];
             
             
             
            //배열 입력
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
             
            System.out.print("#" + tc + " ");
             
            //갱신할 최대값
            int max = 0;
             
            //가로, 세로 합 계산
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int sum1 = arr[i][j];
                     
                    for(int dir=0; dir<4; dir++) {
                        for(int l=1; l<m; l++) {
                            int nr = i + dr1[dir] * l;
                            int nc = j + dc1[dir] * l;
                             
                            if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                sum1 += arr[nr][nc];
                            }
                        }
                    }                  
                    //현 위치 변동 때마다 합계 비교
                    max = Math.max(max, sum1);
                }
            }
             
            //대각선 계산
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    int sum2 = arr[i][j];
                     
                    for(int dir=0; dir<4; dir++) {
                        for(int l=1; l<m; l++) {
                            int nr = i + dr2[dir] * l;
                            int nc = j + dc2[dir] * l;
                             
                            if(nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                sum2 += arr[nr][nc];
                            }
                        }
                    }
                    //현 위치 변동 때마다 합계 비교
                    max = Math.max(max, sum2);
                }
            }
            System.out.println(max);
        }
    }
}
 
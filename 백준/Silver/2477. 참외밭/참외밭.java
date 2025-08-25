import java.io.*;
import java.util.*;

//큰직사각형 - 작은 직사각형 
//면적 = (가로최대 × 세로최대) − (작은가로 × 작은세로) → 마지막에 K(㎡당 참외 수)를 곱한다. 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();//1m당 참외개수 
		int[] d = new int[6];// 방향
		int[] L = new int[6];// 길이
		for (int i = 0; i < 6; i++) {
			d[i] = sc.nextInt(); // 방향 
			L[i] = sc.nextInt(); //길이 
		}
		int wMax = 0, wIdx = 0; //가로 최대변과 위치
		int hMax = 0, hIdx = 0; //세로 최대변과 위치 
		for (int i = 0; i < 6; i++) {
			if (d[i] == 1 || d[i] == 2) { //가로 
				if(L[i] > wMax) {wMax = L[i];wIdx = i;}
			}	else {					//세로 
				if(L[i] >hMax) {hMax = L[i]; hIdx = i;}
			}
		}
		int smallW = Math.abs(L[(hIdx +5)%6] - L[(hIdx + 1)% 6]);//세로최대 양옆의 차 -> 작은가로 
		int smallH = Math.abs(L[(wIdx +5)%6] - L[(wIdx + 1)% 6]);//가로최대 양옆의 차 -> 작은세로 

		int area = (wMax * hMax - smallW * smallH) * K; // (큰넓이-작은넓이)*K
		System.out.println(area);
		
		
	}
}
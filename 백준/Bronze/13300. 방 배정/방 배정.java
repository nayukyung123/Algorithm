import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] count = new int[2][7]; // 성별 - 학년
		int roomCount = 0; // 필요한 최소 방의 개수

		for (int j = 0; j < n; j++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 성별 0 여자, 1 남자
			int y = Integer.parseInt(st.nextToken()); // 학년;
			
			count[s][y]++;// 해당 성별-학년 그룹 학생 수 증가 
		
		
		}
		
		for (int s = 0; s < 2; s++) {
			for (int y = 1; y <=6; y++) {
				 int student = count[s][y];
				 
				 if(student > 0) {
					 roomCount += (student+k-1) / k;
					 
				 }
				 
				
			}
			
		}
		System.out.println(roomCount);

	}
}

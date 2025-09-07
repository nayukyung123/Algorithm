import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
			String word = sc.next();
			String sentence = sc.next();
			int count=0;
			int idx = 0;
			
			while ((idx = sentence.indexOf(word, idx))!=-1) {
				count++;
				idx += word.length();
			}

			System.out.println("#" + tc + " "+count);

		}
	}

}
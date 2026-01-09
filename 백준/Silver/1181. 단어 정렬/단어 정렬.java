import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());// 단어 갯수 받기


		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		String[] words = set.toArray(new String[set.size()]);

		Arrays.sort(words, (s1, s2) -> {
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		});

		for (String word : words) {
			System.out.println(word);

		}

	}
}

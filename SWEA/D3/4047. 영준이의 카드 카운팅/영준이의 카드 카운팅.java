import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String input = br.readLine();

			Set<String> set = new HashSet<>();

			int S = 0, D = 0, H = 0, C = 0;

			boolean error = false;

			for (int i = 0; i < input.length(); i += 3) {
				char style = input.charAt(i);
				String number = input.substring(i + 1, i + 3);
				String card = style + number;

				if (!set.add(card)) {
					error = true;
					break;
				}

				if (style == 'S')
					S++;
				else if (style == 'D')
					D++;
				else if (style == 'H')
					H++;
				else if (style == 'C')
					C++;

			}
			System.out.print("#" + tc + " ");
			if (error) {
				System.out.println("ERROR");
			} else {
				System.out.println((13 - S) + " " + (13 - D) + " " + (13 - H) + " " + (13 - C));
			}

		}
	}

}

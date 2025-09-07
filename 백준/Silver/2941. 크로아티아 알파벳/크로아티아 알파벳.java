import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); 
		
		String [] croatia = {"c=", "c-","dz=","d-","lj","nj","s=","z="};
		
		for (String pattern : croatia) {
			s=s.replace(pattern, "*");
		}
		System.out.println(s.length());
	}
}

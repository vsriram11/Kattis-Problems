import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis erase problem
 * problem URL: https://open.kattis.com/problems/erase
 * 
 */

public class Erase {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			int n = io.getInt();
			boolean same = ((n % 2) == 0);
			
			String b = io.getWord();
			String a = io.getWord();
			
			int len = b.length();
			boolean success = true;
			
			for(int i=0; i<len; i++) {
				if (same) {
					if (b.charAt(i) != a.charAt(i)) {
						success = false;
						break;
					}
				} else {
					if (b.charAt(i) == a.charAt(i)) {
						success = false;
						break;
					}
				}
			}
			
			if (success) {
				io.println("Deletion succeeded");
			} else {
				io.println("Deletion failed");
			}
		}
		io.close();
	}
}

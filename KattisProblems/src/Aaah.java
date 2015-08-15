import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis aaah problem
 * problem URL: https://open.kattis.com/problems/aaah
 * 
 */

public class Aaah {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			String d = io.getWord();
			String j = io.getWord();
			
			if (d.length() >= j.length()) {
				io.println("go");
			} else {
				io.println("no");
			}
		}
		io.close();
	}
}

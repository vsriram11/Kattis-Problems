import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Kattis cookieselection problem
 * problem URL: https://open.kattis.com/problems/cookieselection
 * 
 */

public class CookieSelection {
	
	public static List<Integer> cookies = new ArrayList<Integer>();
	public static int size=0;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			String d = io.getWord();
			
			if (d.equals("#")) {
				Collections.sort(cookies);
				io.println(removeMedian());
			} else {
				cookies.add(Integer.valueOf(d));
				size++;
			}
		}
		io.close();
	}
	
	public static int removeMedian() {
		if (size % 2 == 0) {
			int res = cookies.remove(((size) / 2));
			size--;
			return res;
		} else {
			int res = cookies.remove(((size + 1) / 2) - 1);
			size--;
			return res;
		}
	}
}

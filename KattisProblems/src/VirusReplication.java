import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis virus problem
 * problem URL: https://open.kattis.com/problems/virus
 * 
 */

public class VirusReplication {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			String a = io.getWord();
			String b = io.getWord();
			
			if (a.equals(b)) {
				io.println(0);
				continue;
			} else if (b.contains(a) && a.charAt(0) == b.charAt(0)) {
				io.println(b.length() - a.length());
				continue;
			} else if (a.contains(b) && a.charAt(0) == b.charAt(0)) {
				io.println(0);
				continue;
			}
			
			int len1 = a.length();
			int len2 = b.length();
			int largerlen = len1;
			int smallerlen = len2;
			
			boolean reversed = false;
			
			if (len2 > len1) {
				largerlen = len2;
				smallerlen = len1;
				reversed = true;
			}
			
			int startIndex = -1;
			
			for (int i=0; i < smallerlen; i++) {
				if (a.charAt(i) == b.charAt(i)) {
					continue;
				} else {
					startIndex = i;
					break;
				}
			}
			
			int endIndex1 = -1;
			int endIndex2 = -1;
			
			int k = smallerlen-1;
			for (int j=largerlen-1; j >= 0; j--) {
				boolean criticalCheck;
				if (reversed) {
					criticalCheck = b.charAt(j) == a.charAt(k);
				} else {
					criticalCheck = a.charAt(j) == b.charAt(k);
				}
				
				if (criticalCheck) {
					k--;
					continue;
				} else {
					endIndex1 = j;
					endIndex2 = k;
					break;
				}
			}
			
			if (reversed)
				io.println(endIndex1 - startIndex + 1);
			else
				io.println(endIndex2 - startIndex + 1);
			
		}
		io.close();
	}
}

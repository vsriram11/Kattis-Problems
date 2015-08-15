import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis doorman problem
 * problem URL: https://open.kattis.com/problems/doorman
 * 
 */

public class Doorman {
	
	public static int threshhold;
	public static int men = 0;
	public static int women = 0;
	public static boolean manWaiting = false;
	public static boolean womanWaiting = false;
	
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			threshhold = io.getInt();
			String line = io.getWord();
			int n = line.length();
			
			int i;
			for (i=0; i< n; i++) {
				char ch = line.charAt(i);
				if (ch == 'M') {
					men++;
				} else {
					women++;
				}
				
				if (Math.abs(women - men) >= threshhold + 2) {
					break;
				}
			}
			
			if (Math.abs(women - men) >= threshhold + 2) {
				io.println(women + men - 2);
			}
			else if (Math.abs(women - men) >= threshhold + 1)  {
				io.println(women + men - 1);
			}
			else {
				io.println(women + men);
			}
			
			/*for (int i=0; i< n; i++) {
				char ch = line.charAt(i);
				if (ch == 'M') {
					men++;
				} else {
					women++;
				}
				
				if (men - women > threshhold) {
					men--;
					if (manWaiting) break;
					else {
						if (womanWaiting) {
							women++;
							womanWaiting = false;
							men++;
						} else {
							manWaiting = true;
						}
					}
				} else if (women - men > threshhold) {
					women--;
					if (womanWaiting) break;
					else {
						if (manWaiting) {
							men++;
							manWaiting = false;
							women++;
						} else {
							womanWaiting = true;
						}
					}
				}
			}*/
			
		}
		io.close();
	}
}

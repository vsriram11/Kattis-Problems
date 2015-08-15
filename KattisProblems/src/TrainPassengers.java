import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis trainpassengers problem
 * problem URL: https://open.kattis.com/problems/trainpassengers
 * 
 */

public class TrainPassengers {
	
	public static int C;
	public static int n;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			C = io.getInt(); n = io.getInt();
			
			boolean possible = true;
			
			int numPass = 0;
			for (int i = 0; i < n; i++) {
				int numLeft = io.getInt();
				int numEnter = io.getInt();
				int numWaiting = io.getInt();
				
				numPass += numEnter;
				numPass -= numLeft;
				
				if (i == 0 && numLeft > 0) {
					possible = false;
				} if (i == n - 1 && (numWaiting > 0 || numPass > 0)) {
					possible = false;
				}
				
				// exceeds capacity
				if (numPass > C) {
					possible = false;
				}
				
				// less than 0
				if (numPass < 0) {
					possible = false;
				}
				
				int left = C - numPass;
				
				// waiting in vain
				if (left > 0 && numWaiting > 0) {
					possible = false;
				}
			}
			
			if (possible)
				io.println("possible");
			else
				io.println("impossible");
		}
		io.close();
	}
	
}

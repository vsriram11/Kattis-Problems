import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Kattis ceremony problem
 * problem URL: https://open.kattis.com/problems/ceremony
 * 
 */

public class Ceremony {
	
	public static int N;
	public static int[] x;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			N = io.getInt();
			x = new int[N];
			
			for (int i=0; i < N; i++) {
				x[i] = io.getInt();
			}
			
			Arrays.sort(x);
			
			int minSwipes = N;
			for (int i=N-1; i >= 0; i--) {
				int swipes = x[i] + ((N-1) - i);
				if (swipes <= minSwipes) {
					minSwipes = swipes;
				}
			}
			
			io.println(minSwipes);
			
		}
		io.close();
	}
}

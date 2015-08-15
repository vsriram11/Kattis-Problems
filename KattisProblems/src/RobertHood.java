import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis roberthood problem
 * problem URL: https://open.kattis.com/problems/roberthood
 * 
 */

public class RobertHood {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			int c = io.getInt();
			int[] x_i = new int[c];
			int[] y_i = new int[c];
			
			for (int i=0; i<c; i++) {
				x_i[i] = io.getInt();
				y_i[i] = io.getInt();
			}
			
			double maxDist = 0.0;
			for (int i=0; i<c; i++) {
				for (int j=i+1; j<c; j++) {
					double num = Math.pow((x_i[i] - x_i[j]), 2) + Math.pow(y_i[i] - y_i[j], 2);
					if (num > maxDist) {
						maxDist = num;
					}
				}
			}
			
			io.println(Math.sqrt(maxDist));
		}
		io.close();
	}
}

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * Kattis plantingtrees problem
 * problem URL: https://open.kattis.com/problems/plantingtrees
 * 
 */

public class PlantingTrees {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			int n = io.getInt();
			Integer[] t_i = new Integer[n];
			
			for (int i=0; i<n; i++) {
				t_i[i] = io.getInt();
			}
			
			Arrays.sort(t_i, Collections.reverseOrder());
			
			int maxDays = 1;
			for (int i=0; i<n; i++) {
				int timeDone = (i+1) + t_i[i];
				if (timeDone > maxDays) {
					maxDays = timeDone;
				}
			}
			
			io.println(maxDays + 1);
		}
		io.close();
	}
}

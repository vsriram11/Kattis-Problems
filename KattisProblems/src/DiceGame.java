import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis dicegame problem
 * problem URL: https://open.kattis.com/problems/dicegame
 * 
 */

public class DiceGame {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			// Gunnar
			int ming = io.getInt();
			int maxg = io.getInt();
			int leng = maxg - ming + 1;
			
			int sumg = 0;
			for (int i=ming; i <= maxg; i++) {
				sumg += i;
			}
			
			double g_d1 = (double)sumg / leng;
			
			ming = io.getInt();
			maxg = io.getInt();
			leng = maxg - ming + 1;
			
			sumg = 0;
			for (int i=ming; i <= maxg; i++) {
				sumg += i;
			}
			
			double g_d2 = (double)sumg / leng;
			
			double g_e = g_d1 + g_d2;
			
			// Emma
			int mine = io.getInt();
			int maxe = io.getInt();
			int lene = maxe - mine + 1;
			
			int sume = 0;
			for (int i=mine; i <= maxe; i++) {
				sume += i;
			}
			
			
			
			double e_d1 = (double)sume / lene;
			
			mine = io.getInt();
			maxe = io.getInt();
			lene = maxe - mine + 1;
			
			sume = 0;
			for (int i=mine; i <= maxe; i++) {
				sume += i;
			}
			
			double e_d2 = (double)sume / lene;
			
			double e_e = e_d1 + e_d2;
			
			double precision = Math.pow(10, -2);
			
			if (e_e - g_e > precision) {
				io.println("Emma");
			} else if (g_e - e_e > precision) {
				io.println("Gunnar");
			} else {
				io.println("Tie");
			}
			
		}
		io.close();
	}
}

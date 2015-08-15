
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis dartboard problem
 * problem URL: https://open.kattis.com/problems/dartboard
 * 
 */

public class Dartboard {
	
	public static double sigma;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			double bullEye = io.getDouble();
			double bull = io.getDouble();
			
			double innerTriple = io.getDouble();
			double outerTriple = io.getDouble();
			double innerDouble = io.getDouble();
			double outerDouble = io.getDouble();
			
			sigma = io.getDouble();
			
			double expectation = 50.0 * probabilityWithinBounds(0, bullEye);
			expectation += (25.0 * probabilityWithinBounds(bullEye, bull));
			
			for (int i=1; i<=20; i++) {
				expectation += (i * (probabilityWithinBounds(bull, innerTriple) / 20.0));
			}
			
			for (int i=1; i<=20; i++) {
				expectation += ((i * 3) * (probabilityWithinBounds(innerTriple, outerTriple) / 20.0));
			}
			
			for (int i=1; i<=20; i++) {
				expectation += (i * (probabilityWithinBounds(outerTriple, innerDouble) / 20.0));
			}
			
			for (int i=1; i<=20; i++) {
				expectation += (i * 2 * (probabilityWithinBounds(innerDouble, outerDouble) / 20.0));
			}
			
			io.println(expectation);
		}
		io.close();
	}
	
	public static double probabilityWithinBounds(double start, double end) {
		return analyticalSolutionToIndefiniteIntegral(end) - analyticalSolutionToIndefiniteIntegral(start);
	}
	
	public static double analyticalSolutionToIndefiniteIntegral(double r) {
		return -1.0 * Math.pow(Math.E, -Math.pow(r, 2) / (2 * Math.pow(sigma, 2)));
	}
}
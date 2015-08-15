import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * Kattis timebomb problem
 * problem URL: https://open.kattis.com/problems/timebomb
 * 
 */

public class TimeBomb {
	
	public static String zero = "***\n* *\n* *\n* *\n***\n";
	public static String one = "  *\n  *\n  *\n  *\n  *\n";
	public static String two = "***\n  *\n***\n*  \n***\n";
	public static String three = "***\n  *\n***\n  *\n***\n";
	public static String four = "* *\n* *\n***\n  *\n  *\n";
	public static String five = "***\n*  \n***\n  *\n***\n";
	public static String six = "***\n*  \n***\n* *\n***\n";
	public static String seven = "***\n  *\n  *\n  *\n  *\n";
	public static String eight = "***\n* *\n***\n* *\n***\n";
	public static String nine = "***\n* *\n***\n  *\n***\n";
	public static String[] definedDigits = new String[10];
	
	public static void fillInDefinition() {
		definedDigits[0] = zero;
		definedDigits[1] = one;
		definedDigits[2] = two;
		definedDigits[3] = three;
		definedDigits[4] = four;
		definedDigits[5] = five;
		definedDigits[6] = six;
		definedDigits[7] = seven;
		definedDigits[8] = eight;
		definedDigits[9] = nine;
	}
	
	public static void main(String[] args) {
		fillInDefinition();
		
		Kattio io = new Kattio(System.in, System.out);
	
		String[] lines = new String[5];
			
		for (int i=0; i < 5; i++) {
			lines[i] = io.getLine();
		}
		
		int len = lines[0].length();
		int numDigits = (len + 1) / 4;
		
		String[] digits = new String[numDigits];
		for (int i=0; i < numDigits; i++) {
			digits[i] = "";
		}
		
		for (int i=0; i < 5; i++) {
			String line = lines[i];
			int offset = 0;
			for (int j=0; j<numDigits; j++) {
				digits[j] += (line.substring(offset, offset + 3) + "\n");
				offset += 4;
			}
		}
		
		String num = "";
		boolean isNum = true;
		
		for (int i=0; i < numDigits; i++) {
			String x = findDigitRep(digits[i]);
			if (x == "invalid") {
				isNum = false;
				break;
			} else {
				num += x;
			}
		}
		
		if (isNum) {
			int finalNum = Integer.valueOf(num);
			if ((finalNum % 6) == 0) {
				io.println("BEER!!");
			} else {
				io.println("BOOM!!");
			}
		} else {
			io.println("BOOM!!");
		}
			
		io.close();
	}
	
	public static String findDigitRep(String d) {
		String dstr = "invalid";
		for (int i=0; i < 10; i++) {
			String defined = definedDigits[i];
			if (defined.equals(d)) {
				dstr = String.valueOf(i);
			}
		}
		return dstr;
	}
}

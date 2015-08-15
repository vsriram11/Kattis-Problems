import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Kattis horror problem
 * problem URL: https://open.kattis.com/problems/horror
 * 
 */

public class Horror {
	
	public static double[] horrorInds;
	public static ArrayList<Integer>[] similarities;
	// make sure that we process from most horrific to least
	public static Queue<Integer> similarityOrder = new LinkedList<Integer>();
	
	// do not re-add elements to the queue
	public static int[] visited;
	
	public static int N; public static int H; public static int L;
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in, System.out);
		
		while (io.hasMoreTokens()) {
			N = io.getInt(); H = io.getInt(); L = io.getInt();
			
			horrorInds = new double[N]; initializeToInf();
			similarities = (ArrayList<Integer>[]) new ArrayList[N]; instantiateArrays();
			visited = new int[N];
			
			// read in horror indices
			for (int i=0; i < H; i++) {
				int horror = io.getInt();
				horrorInds[horror] = 0;
				visited[horror] = 1;
				similarityOrder.add(horror);
			}
			
			// read in similarities
			for (int i=0; i < L; i++) {
				int a = io.getInt(); int b = io.getInt();
				similarities[a].add(b);
				similarities[b].add(a);
			}
			
			// generate horror indices
			while (!similarityOrder.isEmpty()) {
				int nxtIndex = similarityOrder.poll();
				ArrayList<Integer> x = similarities[nxtIndex];
				int len = x.size();
				for (int i=0; i < len; i++) {
					int child = x.get(i);
					if (visited[child] == 0) {
						horrorInds[child] = horrorInds[nxtIndex] + 1;
						similarityOrder.add(child);
						visited[nxtIndex] = 1;
					}
				}
			}
			
			io.println(findHighestHorrorIndex());
		}
		io.close();
	}
	
	public static int findHighestHorrorIndex() {
		int maxIndex = 0;
		for (int i=0; i < N; i++) {
			if (horrorInds[i] > horrorInds[maxIndex]) {
				maxIndex = i;
			}
		}
		
		double maxValue = horrorInds[maxIndex];
		List<Integer> maxIndices = new ArrayList<Integer>();
		for (int i=0; i < N; i++) {
			if (horrorInds[i] == maxValue) {
				maxIndices.add(i);
			}
		}
		
		if (maxIndices.size() == 1) {
			return maxIndex;
		} else {
			Collections.sort(maxIndices);
			return maxIndices.get(0);
		}
	}
	
	public static void initializeToInf() {
		for (int i=0; i < N; i++) {
			horrorInds[i] = Double.POSITIVE_INFINITY;
		}
	}
	
	public static void instantiateArrays() {
		for (int i=0; i < N; i++) {
			similarities[i] = new ArrayList<Integer>();
		}
	}
}

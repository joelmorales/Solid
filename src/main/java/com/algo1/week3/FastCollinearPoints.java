package com.algo1.week3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {

	private ArrayList<LineSegment> segmentList = new ArrayList<>();

	public FastCollinearPoints(Point[] points) {
		if (points == null)
			throw new NullPointerException();

		Point[] aux = Arrays.copyOf(points, points.length);
		
		for (int i = 0; i < points.length; i++) {
			Point p = points[i];
			Arrays.sort(aux);
			Arrays.sort(aux, p.slopeOrder());

			int min = 0;
			//They are equal
			while (min < aux.length && p.slopeTo(aux[min]) == Double.NEGATIVE_INFINITY){
				min++;
			}
			if (min != 1)
				throw new IllegalArgumentException();// check duplicate points
			int max = min;
			while (min < aux.length) {
				while (max < aux.length && p.slopeTo(aux[max]) == p.slopeTo(aux[min]))
					max++;
				if (max - min >= 3) {
					Point pMin = aux[min].compareTo(p) < 0 ? aux[min] : p;
					Point pMax = aux[max - 1].compareTo(p) > 0 ? aux[max - 1] : p;
					if (p == pMin)
						segmentList.add(new LineSegment(pMin, pMax));
				}
				min = max;
			}
		}

	}

	public LineSegment[] segments() {
        return segmentList.toArray(new LineSegment[segmentList.size()]);
    }
	
	
	public static void main(String[] args) {

	    // read the n points from a file
	    //In in = new In(args[0]);
		File file = new File("c:/tmp/input6.txt");
		
		In in = new In(file);
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();

	    // print and draw the line segments
	    FastCollinearPoints collinear = new FastCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	        StdOut.println(segment);
	        segment.draw();
	    }
	    StdDraw.show();
	}
	
}

import java.awt.Graphics;
import java.util.Comparator;

public class Point implements Comparable<Point> {

	private int x;
	private int y;
	
	
	// 2 dimensional point with Comparable interface
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}




	
	
	
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	

	// Compares points using the conic order in 2 dimensional real space
	
	public int compareTo(Point that) {
		if(y< that.y) {
			return -1;
		}else if(y == that.y){
			if(x<that.x) {
				return -1;
			}else if(x == that.x){
				return 0;			
			}else {
				return 1;
			}
		}else { return 1;}	
	
	}
	
	// Returns tan of the slope angle of a line passing through 2 points
	public double slopeTo(Point that) {
		if(y==that.y && x==that.x) {
			return Double.NEGATIVE_INFINITY;
		}else if(y!=that.y && x==that.x) {
			return Double.POSITIVE_INFINITY;
		}else {
			return (double)(that.y - y)/(double)(that.x - x);			
		}
		
	}

	
	// Compares slope angles of 2 lines
	public Comparator<Point> slopeOrder() {
	    final Point that = this;
	    return new Comparator<Point>() {

	        public int compare(Point p1, Point p2) {
	        	return Double.compare(that.slopeTo(p1),that.slopeTo(p2));
	        	
	        	
	        	
	        	
	        }	
	    };	
	 
	}	
	
}	
	
	
	
	
	
	
	
	
	
	
	



public class LineSegment {

private Point p1;
private Point p2;
	
	

//creates a line segment connecting 2 points
	
	
	 public LineSegment(Point p, Point q) {
		 p1 = p;
		 p2 = q;
		 
	 }
	 
	 
	
	 public Point getP1() {
		return p1;
	}


	public Point getP2() {
		return p2;
	}






	public String toString() {
		return "LineSegment [p1=" + p1 + ", p2=" + p2 + "]";
	}
	
	 
	 
	
}

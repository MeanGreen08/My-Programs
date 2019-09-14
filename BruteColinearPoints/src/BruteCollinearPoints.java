import java.util.Comparator;

public class BruteCollinearPoints {

	
	private LineSegment[] ls;
	private Point[] ps;
	

	
	// Brute collinear points searches for groups of 4 points in a given point array and creates a line segment connecting all the points in the found set
	
	public BruteCollinearPoints(Point[] points) {
		 ls = new LineSegment[100];
		 ps = points;
		for(int i = 0; i<points.length; i++) {
			if(points[i] == null) {
				throw new java.lang.NullPointerException();
			}
				for(int j = i+1; j<ps.length; j++) {
					 if(ps[i].slopeTo(ps[j]) == Double.NEGATIVE_INFINITY) {
						 throw new java.lang.IllegalArgumentException();
					 }
			}
	}

		sort();

		
		
		
		segments();	
	}
	
	
	
	// Following method lists all line segments that can be created and prints out line segments containing 4 points
	
	
		 public LineSegment[] segments() {
			  
			  
			  int s = 0;
			 
	
			  
			for(int i = 0; i<ps.length-3; i++) {
				Comparator<Point> com = ps[i].slopeOrder();
				
				for(int j = i+1; j<ps.length-2; j++) {
					
					
					for(int k = j+1; k<ps.length-1; k++) {
						
						for(int r = k+1; r<ps.length; r++) {
							if(com.compare(ps[j], ps[k]) == 0 && com.compare(ps[j], ps[r])==0) {
													
								
								ls[s]= new LineSegment(ps[i],ps[r]);
								s++;
							
								System.out.println(ls[i]);
					}
				}

				}
				
				
				
				
				
				
			}
		     
			} 		 
			 return ls;
			 
		 }
	
		 
		 // Due to instantiating list of line segments with certain size, this method counts existing line segments containing 4 elements
		 public int numberOfSegments() {
			 int k = 0;
			 while(ls[k] != null) {
				 k++;
			 }			 
			 return k;
		 }
	
	
		 
		 // Sorts given array of points in a non-decreasing order using conic order in 2d real space
		 public void sort() {
			 
			for(int i = 1; i<ps.length; i++) {
				for(int j = i; j>0; j--) {
					if(ps[j].compareTo(ps[j-1])==-1) {
						Point a = ps[j-1];
						ps[j-1]=ps[j];
						ps[j]=a;
						}
				}
			}
	 }
		 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

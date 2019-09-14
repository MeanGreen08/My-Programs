package percolation;

import site.Site;

public class Percolation {

	private Site[][] grid;
	private int[][] size;
	
	
	
	// n x n grid constructor 
	
	public Percolation(int n) {
		
		grid = new Site[n][n];
		size = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j = 0; j<n; j++) {
				grid[i][j] = new Site() ;
				size [i][j] = 0;
				
			}
		}			
	}	
	//method that opens gird boxes
	
	   public void open(int i, int j) {	
		   validate(i);
		   validate(j);
		   
		   int[] a = new int[4];
		   int[] b = new int[4];

		   for(int k = 0; k<4; k++) {
			   a[k]= -1;  
		   }
		   for(int k = 0; k<4; k++) {
			   b[k]= -1;
		   }
		   if(isOpen(i,j)) {
		   }else {		   
		   if(i>0) {
			   if(isOpen(i-1,j)) {
				   a[0]=rootOf(i-1,j)[0];
				   b[0]=rootOf(i-1,j)[1];				   					   
			   }
		   }
		   if(i<grid.length-1) {
			   if(isOpen(i+1,j)) {
				   a[1]=rootOf(i+1,j)[0];
				   b[1]=rootOf(i+1,j)[1];
			   }
		   }
		   if(j>0) {
			   if(isOpen(i,j-1)) {
				   a[2]=rootOf(i,j-1)[0];
				   b[2]=rootOf(i,j-1)[1];			   
			   }
		   }
		   if(j<grid.length-1) {
			   if(isOpen(i,j+1)) {
				   a[3]=rootOf(i,j+1)[0];
				   b[3]=rootOf(i,j+1)[1];
				   }
			   }
		   }		   
		   int id = -1;
		   int q = 0;
		   while(id<0 && q<4){			   
			   if(a[q]>-1) {
				   id=q;
			   } else {q++;}
		   }
		   if(id>-1) {
		   for(int k = id+1; k<4 ; k++) {
			   if(a[k]>-1 && size[a[id]][b[id]] < size[a[k]][b[k]]) {
				   id = k;
			   }
		   	}
			   grid[i][j].setRow(a[id]);
			   grid[i][j].setColumn(b[id]);  
			   size[a[id]][b[id]]++;
			   for(int t = 0; t<4; t++) {
				   if(t!=id && a[t]>-1) {
					   size[a[id]][b[id]] = size[a[id]][b[id]] + size[a[t]][b[t]];
					   grid[a[t]][b[t]].setRow(a[id]);
					   grid[a[t]][b[t]].setColumn(b[id]);
					   
				   }
			   }
		   	}
		   else {
		   grid[i][j].setRow(i);
		   grid[i][j].setColumn(j);
		   size[i][j]=1;
		   }
	   }
	   
	   //check if grid box is already open
	   public boolean isOpen(int i, int j) {
		   validate(i);
		   validate(j);
		   
		   if(grid[i][j].getRow() != -1) {
			 
			   return true;
		   }
		   return false;
	   }    
	   
	   //check if gridbox is full
	   public boolean isFull(int i, int j) {
		   validate(i);
		   validate(j);

		   	if(isOpen(i,j)) {	   
		   for(int k = 0; k < grid.length ; k++) {
		   if(isOpen(0,k)) {
		   if(rootOf(i,j)[0] == rootOf(0,k)[0] && rootOf(i,j)[1] == rootOf(0,k)[1]) {			   	
			 
			   return true;	
		   		}
		   		}
		      } 
		   }
		
		   return false;
		 
	   }   
	   
	   //check if the system percolates, if there is a path of open grid boxes  connecting top row with bottom row
	   public boolean percolates(){		   
		   for(int i = 0; i<grid.length; i++) {
			 if(isFull( grid.length - 1, i)) {
			   return true;
			 }
		   }
		   return false;
	   }        
	
	   //check if the coordinates of the grid box is within range
	private void validate(int i) {
		if(i<0 || i>grid.length -1) {
		throw new IllegalArgumentException("indeks " + i + " nie nale¿y do liczb od 0 do " + (grid.length-1));
		}
	}
	
	//check roots of the open grid
	private int[] rootOf(int i, int j) {
		int[] roots = new int[2];
		
		int a = i;
		int b = j;
		int r = a;
		while(grid[a][b].getRow() !=a || grid[a][b].getColumn() != b) {
			r = a;
			a = grid[a][b].getRow();
			b = grid[r][b].getColumn();
		}
		roots[0] = a;
		roots[1] = b;		
		return roots;
	}
	
	
	
}

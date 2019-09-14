package percolation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import percolation.Percolation;

public class PercolationStats {

	private int k;
	private int[] p;
	
	
	public PercolationStats(int n, int trials) {
		if(n<1 || trials <1) { throw new IllegalArgumentException("rozmiar siatki lub iloœæ powtórzeñ musi byæ dodatni¹ liczb¹ ca³kowit¹" );
		}
		p = new int[trials];
		
		for(int i = 0; i<trials; i++) {
			
			 k = 0;
			 Random rnd = new Random();
			 int q = n*n;
			 List<Integer> L = new ArrayList<Integer>(q);
			 for(int j = 0; j<q; j++) {
				 L.add(j);
			 }
			 
			Percolation grid = new Percolation(n);			
				do{
				int a1 = rnd.nextInt(L.size());
				int b1 = L.get(a1);
				L.remove(a1);
				int a = b1 % n;			
				int b = (b1-a)/n;
				grid.open(a, b);
				k++;
			
			}while(grid.percolates() == false);
			p[i]=k;
		}	
	}
	
	//methods for mean, standard deviation and confidence interval for multiple trials
	
	   public double mean() {
		   int suma = 0;
		   double sr = 0;
		   for(int i = 0; i <p.length; i++) {
			   suma = suma + p[i];			  
		   }
		   sr = suma/p.length;
		   return sr;
	   }
	   public double stddev() {
		   double suma = 0;
		   double sd = 0;
		   if(p.length > 1) {
		   for(int i = 0; i <p.length; i++) {
			   suma = suma + (p[i]-mean())*(p[i]-mean());			  
		   }		   
		   sd =Math.sqrt(suma/(p.length - 1));
		   }else {sd=0;}
		   return sd;
		   
	   }
	   public double confidenceLo() {
		  return (mean()-(1.96*stddev())/Math.sqrt(p.length));
	   }
	   public double confidenceHi() {
		   return (mean()+(1.96*stddev())/Math.sqrt(p.length));
	   }
	
	
	
}

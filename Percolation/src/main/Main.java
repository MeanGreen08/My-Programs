package main;


import percolation.PercolationStats;


public class Main {
	
	public static void main(String[] args) {
		

	
	
	
	PercolationStats proby = new PercolationStats(10,10);
	
	
	System.out.println("///////");
	
	System.out.println("srednia z proby " + proby.mean());
	System.out.println("odchylenie standardowe " + proby.stddev());
	System.out.println("przedzial ufnosci [" + proby.confidenceLo() + " , " + proby.confidenceHi() + "]");
	
		
}
	
	
	
}

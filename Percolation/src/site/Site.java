package site;

public class Site {

	private int row;
	private int column;
	
	
	// single grid box constructor (aka Site)
	
	public Site() {
		row=-1;
		column=-1;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}


}

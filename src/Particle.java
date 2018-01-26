import java.awt.Color;
public class Particle 
{
	protected Color color;
	protected Particle[][] grid;
	public Particle(Particle[][] grid)
	{
		this.grid = grid;
	}
	public Color getColor()
	{
		return color;
	}
	public void act(int row, int col)
	{
	}	
	protected void swap(int rowFrom, int colFrom, int rowTo, int colTo)
	{
		Particle temp = grid[rowFrom][colFrom];
		grid[rowFrom][colFrom] = grid[rowTo][colTo];
		grid[rowTo][colTo] = temp;
	}
	protected void fall(int row, int col)
	{
			int dir = (int)(Math.random() *2);
			if(dir == 0)
			{
				if(col - 1 >= 0 && grid[row + 2][col -1] == null)
				{
					swap(row, col, row +2, col -1);
				}
			}
			else if(dir == 1)
			{
				if(col + 1 < grid[0].length && grid[row + 2][col +1] == null)
				{
					swap(row, col, row +2, col +1);
				}
			}
	}
}

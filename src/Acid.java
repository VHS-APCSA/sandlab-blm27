import java.awt.Color;
public class Acid extends Lava
{
	public Acid(Particle[][] grid)
	{
		super(grid);
		color = Color.green;
	}
	@Override 
	public void act(int row, int col)
	{
		if(row + 1 < grid.length)
		{
			if(grid[row +1][col] == null)
			{
				swap(row, col, row +1, col);
			}
			else if (row + 2 < grid.length)
			{
				fall(row, col);
				melt(row, col);
			}
		}
	}
}
import java.awt.Color;
public class Snow extends Water
{
	public Snow(Particle[][] grid)
	{
		super(grid);
		color = Color.white;
	}
	@Override 
	public void act(int row, int col)
	{
		if(row +2 < grid.length)
		{
			if(grid[row+2][col] != null)
			{
				fall(row, col);
			}
		}
		if(row +1 < grid.length)
		{
			if(grid[row +1][col] == null && Math.random() < 0.2)
			{
				super.act(row, col);
			}
		}
		if(row +1 < grid.length && grid[row +1][col] instanceof Water && !(grid[row +1][col] instanceof Snow))//melt snow
		{
			grid[row][col] = new Water(grid);
		}
		if(row -1 < grid.length && grid[row -1][col] instanceof Water && !(grid[row -1][col] instanceof Snow))//melt snow
		{
			grid[row][col] = new Water(grid);
		}
	}
}


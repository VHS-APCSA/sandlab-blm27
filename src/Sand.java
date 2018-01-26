import java.awt.Color;
public class Sand extends Particle
{
	public Sand(Particle[][] grid)
	{
		super(grid);
		color = Color.yellow;
	}
	@Override 
	public void act(int row, int col)
	{
		if(row + 1 < grid.length)
		{
			if(grid[row +1][col] == null || grid[row +1][col] instanceof Water)
			{
				swap(row, col, row +1, col);
			}
			else if (row + 2 < grid.length && grid[row +1][col] instanceof Sand)
			{
				fall(row, col);
			}
		}
	}
}


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
			if(row +1 < grid.length)
			{
				if(grid[row +1][col] == null && Math.random() < 0.2)
				{
					super.act(row, col);
				}
			}
			if(row +1 < grid.length && grid[row +1][col] instanceof Lava && !(grid[row +1][col] instanceof Acid))//turn acid into lava
			{
				grid[row + 1][col] = new Lava(grid);
			}
			if(row -1 < grid.length && grid[row -1][col] instanceof Lava && !(grid[row -1][col] instanceof Acid))//turn acid into lava
			{
				grid[row][col] = new Lava(grid);
			}
			if(row +1 < grid.length && grid[row +1][col] instanceof Water && !(grid[row +1][col] instanceof Acid))//acid goes through water
			{
				grid[row+1][col] = new Acid(grid);
			}
			if(row +1 < grid.length && grid[row +1][col] instanceof Metal && !(grid[row +1][col] instanceof Acid))//melt metal
			{
				grid[row +1][col] = new Acid(grid);
			}
		}
	}
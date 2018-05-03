import java.awt.Color;
public class Lava extends Water
{
	public Lava(Particle[][] grid)
	{
		super(grid);
		color = Color.red;
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
			}
		}
		if(row +1 < grid.length && grid[row +1][col] instanceof Water && !(grid[row +1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//turn water into obsidian
		{
			grid[row + 1][col] = new Obsidian(grid);
		}
		if(row +1 < grid.length && grid[row -1][col] instanceof Water && !(grid[row -1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//turn water into obsidian
		{
			grid[row][col] = new Obsidian(grid);
		}
		if(row +1 < grid.length && grid[row +1][col] instanceof Snow && !(grid[row +1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//snow turns into obsidian
		{
			grid[row + 1][col] = new Obsidian(grid);
		}
		if(row +1 < grid.length && grid[row -1][col] instanceof Snow && !(grid[row -1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//snow turns into obsidian
		{
			grid[row][col] = new Obsidian(grid);
		}
		if(row +1 < grid.length && grid[row +1][col] instanceof Sand && !(grid[row +1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//sand turns into lava
		{
			grid[row + 1][col] = new Lava(grid);
		}
		if(row -1 < grid.length && grid[row -1][col] instanceof Sand && !(grid[row -1][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//sand turns into lava
		{
			grid[row][col] = new Lava(grid);
		}
		if(row +1 < grid.length && grid[row][col] instanceof Metal && !(grid[row][col] instanceof Lava) && !(grid[row][col] instanceof Acid))//melt metal
		{
			grid[row +1][col] = new Lava(grid);
		}
		if(row +1 < grid.length && grid[row +1][col] instanceof Acid && !(grid[row][col] instanceof Lava))
		{
			grid[row+1][col] = new Lava(grid);
		}
		if(row -1 < grid.length && grid[row -1][col] instanceof Acid && !(grid[row -1][col] instanceof Lava))
		{
			grid[row-1][col] = new Lava(grid);
		}
	}
}

import java.awt.Color;
public class Obsidian extends Particle
{
	public Obsidian(Particle[][] grid)
	{
		super(grid);
		color = Color.magenta;
	}
	@Override 
	public void act(int row, int col)
	{
		if(row +1 < grid.length && col +1 < grid.length && grid[row +1][col] instanceof Water 
				&& !(grid[row +1][col] instanceof Obsidian))//melt metal
		{
			grid[row +1][col] = new Obsidian(grid);
		}
	}
}
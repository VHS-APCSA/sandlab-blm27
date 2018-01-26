import java.awt.Color;
public class Water extends Particle
{
	public Water(Particle[][] grid)
	{
		super(grid);
		color = Color.blue;
	}
	@Override 
	public void act(int row, int col)
	{
		int dir = (int)(Math.random() *3);
		if(dir == 0) //move down
		{
			if(row +1 < grid.length && grid[row +1][col] == null)
			{
				swap(row, col, row +1, col);
			}
		}
		else if (dir == 1) //move left
		{
			if(col - 1 >= 0 && grid[row][col -1] == null)
			{
				swap(row, col, row, col -1);
			}
		}
		else if (dir == 2) //move right
		{
			if(col + 1 < grid[0].length && grid[row][col +1] == null)
			{
				swap(row, col, row, col +1);
			}
		}
	}
}
import java.awt.Color;

public class Sand extends Particle
{
	public Sand(Particle[][] grid)
	{
		super(grid);
		color = Color.orange;
	}
	@Override
	public void act(int row, int col)
	{
	   if(row + 1 < grid.length)
	   {
		   Particle below = grid[row + 1][col];
		   if(below == null || below instanceof Water)
		   {
			   grid[row][col] = below;
			   grid[row + 1][col] = new Sand(grid);
		   }
		   else if(row + 2 < grid.length && !(below instanceof Metal) )
		   {
			   int side = 0;
			   if(col + 1 < grid[0].length && col > 1)//fall to left or right
			   {
				   side = (int)(Math.random() * 2);
				   if(side == 0)
					   side = -1;
			   }
			   else if(col + 1 < grid[0].length)//fall to left
			   {
				   side = 1;
			   }
			   else if (col > 1)//fall to right
			   {
				   side = -1;
			   }
			   Particle fall = grid[row + 2][col + side];
			   if(side != 0 && (fall == null || fall instanceof Water))
			   {
				   grid[row][col] = fall;
				   grid[row + 2][col + side] = new Sand(grid);
			   }
		   }
	   }
	}
}

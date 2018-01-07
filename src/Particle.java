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
}

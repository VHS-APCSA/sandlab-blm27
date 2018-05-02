import java.awt.*;
import java.util.*;

/**
 * Project and code modified from
 * http://nifty.stanford.edu/2017/feinberg-falling-sand/assignmentwithoutarrays.html
 *
 */

public class SandLab
{

	//add constants for particle types here
	public static final int EMPTY = 0;
	public static final int METAL = 1;
	public static final int SAND = 2;
	private static final int WATER = 3;
	private static final int SNOW = 4;
	private static final int LAVA = 5;
	private static final int ACID = 6;

	private SandDisplay display;

	private Particle[][] grid;

	public SandLab(int numRows, int numCols)
	{
		String[] names = new String[7];
		names[EMPTY] = "Empty";
		names[METAL] = "Metal";
		names[SAND] = "Sand";
		names[WATER] = "Water";
		names[SNOW] = "Snow";
		names[LAVA] = "Lava";
		names[ACID] = "Acid";
		display = new SandDisplay("Falling Sand", numRows, numCols, names);
		grid = new Particle[numRows][numCols];
	}

	//called when the user clicks on a location using the given tool
	private void locationClicked(int row, int col, int tool)
	{
		Particle particle = null;
		switch(tool)
		{
		case METAL:
			particle = new Metal(grid);
			break;
		case SAND:
			particle = new Sand(grid);
			break;
		case WATER: 
			particle = new Water(grid);
			break;
		case SNOW:
			particle = new Snow(grid);
			break;
		case LAVA:
			particle = new Lava(grid);
			break;
		case ACID:
			particle = new Acid(grid);
			break;
		}
		grid[row][col] = particle;
	}

	//tells display what color to show for each value in the display
	public void updateDisplay()
	{
		for(int row = 0; row < grid.length; row++)
		{
			for(int col = 0; col < grid[0].length; col++)
			{
				Particle particle = grid[row][col];
				if(particle != null)
				{
					display.setColor(row, col, particle.getColor());
				}
				else
				{
					display.setColor(row, col, Color.black);
				}
			}
		}
	}

	//called repeatedly.
	//causes one random particle to maybe do something.
	public void step()
	{
		int row = (int)(Math.random() * grid.length);
		int col = (int)(Math.random() * grid[0].length);
		Particle particle = grid[row][col];
		if(particle != null)
		{
			particle.act(row, col);
		}
	}


	//do not modify
	public static void main(String[] args)
	{
		SandLab lab = new SandLab(120, 80);
		lab.run();
	}

	public void run()
	{
		while (true)
		{
			for (int i = 0; i < display.getSpeed(); i++)
				step();
			updateDisplay();
			display.repaint();
			display.pause(1);  //wait for redrawing and for mouse
			int[] mouseLoc = display.getMouseLocation();
			if (mouseLoc != null)  //test if mouse clicked
				locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
		}
	}
}

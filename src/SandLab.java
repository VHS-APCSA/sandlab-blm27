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
  
  private SandDisplay display;
  
  public SandLab(int numRows, int numCols)
  {
	  String[] names = new String[2];
	  names[EMPTY] = "Empty";
	  names[METAL] = "Metal";
	  display = new SandDisplay("Falling Sand", numRows, numCols, names);
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
	   }
	   grid[row][col] = particle;
  }

  //tells display what color to show for each value in the display
  public void updateDisplay()
  {
  }

  //called repeatedly.
  //causes one random particle to maybe do something.
  public void step()
  {
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

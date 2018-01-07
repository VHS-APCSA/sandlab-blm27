SandLab Directions

SandLab uses a 2D array of Particle objects to store the data of what's on the screen.
Each time through the loop, a particle is chosen at random from the array and act() is called on the Particle.
Each particle act()'s according to its type. 

1) Create a new instance variable that is a 2D array of Particle objects.
   In the constructor use the numRows and numCols parameters to initialize the array to the proper dimensions.
   
2) The locationClicked() method is called (by the run method) whenever the user clicks on some part of the canvas. 
   The selected tool (empty, metal, etc.) is passed to the method.
   Create a new object of the correct type for which tool was selected (i.e. a new Metal object if type is METAL)
   and assign the grid element at row, col this object.
   If the type is EMPTY then set the element equal to null.
   (You won't be able to test this code yet.)
   
3) The updateDisplay method is called (by the run method) at regular intervals. 
   Its job is to draw each particle (and empty space) onto the display.
   Iterate over the entire grid and use SandDisplay's setColor method to show an appropriate color for that particle type at those coordinates. 
   Complete this method so that EMPTY locations are shown in one color (probably black) and METAL locations are shown in another color (probably gray).

    class java.awt.Color
    Color(int red, int green, int blue) // values range from 0 - 255 inclusive

   Test that you can now paint metal particles and erase them.
   
4) Modify your program so that you can also paint with sand particles (probably in yellow). For now, these particles won't actually move.
   Extend the Particle class to make a new Sand class.

5) The step() method is called (by the run method) at regular intervals. 
   This method should choose a single random valid location. (Do not use a loop.) 
   If that location contains a sand particle and the location below it is empty, the particle should move down one row. (Metal particles will never move.)
   Write the logic for the sand particle's motion in the Sand classes act() method.
   The step() method should call the act() method on the selected Particle.
   Test that your sand particles fall now.
   
6) Modify your program so that you can also paint with water particles, which move in one of three randomly chosen directions: down, left, or right.
   Extend the Particle class to make a new Water class.
   In the act() method, pick one of three random directions. 
   If the location in that randomly chosen direction is empty, the water particle moves there. 
   Test that the water behaves roughly like a liquid, taking the shape of a container.
   
7) What happens now when you drop sand particles into water? Right now, sand is only allowed to move into empty spaces. 
   Modify your code so that a sand particle can also move into a space containing a water particle (by trading places with the water particle).

8) Extend the Water class to make a new Snow class that behaves like Water (for now) but is white and falls more slowly.
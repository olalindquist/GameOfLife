# GameOfLife

##QUICKSTART
-  Make sure you are in a terminal in the GameOfLife-folder and that you hava java installed.

-  type: make full and press Enter

-  Enjoy the show

##CHANGE SETUP
- In GameOfLIfe.java
- set xSize and ySize to prefered size (default 50/50)

- set speed (in miliseconds) to increase och slow down game

- to Setup a startpattern use game.addCell(x,y) where x and y is the coordinates
from top left  starting with (1,1)

##RUN TESTS
- In GameOfLifeFolder type: make tests and press enter.

- Junit is included in folder Junit. If for some reason you want to run your own just change the JUnitLib-path in Makefile.

##LIMITATIONS
- All cells just outside the border of the board will never change. Meaning there may be some unexpected behaviour when pattern reaches the border. To prevent this simply make a bigger board och move the setup cell further away from the border (or both!)

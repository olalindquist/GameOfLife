import java.util.*;

public class GameOfLife {


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        //Setup
        boolean gameIsOn = true;
        int xSize = 50;
        int ySize= 50;
        int speed = 100;

        Game game = new Game( xSize,ySize, speed);

        //Add cells to board (x,y) where 1<=x<=xMax &  1<=y<=yMax


        game.addCell(15,15);
        game.addCell(16,15);
        game.addCell(15,16);
        game.addCell(14,16);
        game.addCell(15,17);
        game.showBoard();

         while (gameIsOn)
            {
                game.showBoard();
                game.playRound();
            }

    }
}

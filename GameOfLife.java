import  java.util.concurrent.TimeUnit;

public class GameOfLife {

    public static void switchFields(Board field1, Board field2){
        field1.setMatrix(field2.getMatrix());
    }
public static void main(String[] args) throws InterruptedException{

    //Setup

    boolean gameIsOn = true;
    int xSize = 30;
    int ySize= 30;

    int speed = 100;
    Game game = new Game(xSize, ySize);
    //Add cells to board x,y where 1<=x<=xMax &  1<=y<=yMax
    game.addCell(1,30);
    game.addCell(15,16);
    game.addCell(15,17);
    game.addCell(15,18);
    game.addCell(15,19);

       while (gameIsOn)
           {
             game.playRound();
             game.showBoard();
            TimeUnit.MILLISECONDS.sleep(speed);
           }


}
}

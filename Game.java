import  java.util.concurrent.TimeUnit;

public class Game {

    private Board board;

    private int speed ;

    public Game (int ySize, int xSize, int speed){
        this.board = new Board(xSize, ySize);

        this.speed = speed;
    }

    public void addCell (int x, int y){
        if (x== 0  || y == 0 || x > board.getXSize() || y > board.getYSize()){
            throw new IllegalArgumentException("Cell out of bounds");
        }
        board.makeCellAlive(y,x);
    }



    public void playRound(){
        board.playRound();
        try  {
        TimeUnit.MILLISECONDS.sleep(this.speed);
        }
        catch (Exception e){
            System.out.println("Something wrong with time");
        }
    }

    public void showBoard(){
        System.out.println(board.toString());
    }
}

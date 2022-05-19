import  java.util.concurrent.TimeUnit;

public class Game {

    private Board board1;
    private Board board2;
    private int speed ;

    public Game (int ySize, int xSize, int speed){
        this.board1 = new Board(xSize, ySize);
        this.board2 = new Board(xSize, ySize);
        this.speed = speed;
    }

    public void addCell (int x, int y){
        if (x== 0  || y == 0 || x > board1.getXSize() || y > board1.getYSize()){
            throw new IllegalArgumentException("Cell out of bounds");
        }
        board1.makeCellAlive(y,x);
        board2.makeCellAlive(y,x);
    }

    private void updateBoard(){
        this.board1.setMatrix(board2.getMatrix());
        }

    public void playRound(){
        board1.playRound(board2);
        updateBoard();
        try  {
        TimeUnit.MILLISECONDS.sleep(this.speed);
        }
        catch (Exception e){
            System.out.println("Something wrong with time");
        }
    }

    public void showBoard(){
        System.out.println(board1.toString());
    }
}

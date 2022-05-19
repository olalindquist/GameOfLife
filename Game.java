public class Game{

    private Board board1;
    private Board board2;



    public Game (int xSize, int ySize){
        this.board1 = new Board(xSize, ySize);
        this.board2 = new Board(xSize, ySize);

    }

    public void addCell (int x, int y){
        if (x==0  || y == 0 || x > board1.getXSize() || y >board1.getYSize()){
            throw new IllegalArgumentException("Adding Cell out of bounds");
        }

        board1.makeCellAlive(x,y);
        board2.makeCellAlive(x,y);
    }

    private void updateBoard(){
        this.board1.setMatrix(board2.getMatrix());
        }

    public void playRound(){
        board1.playRound(board2);
        updateBoard();
    }
    public void showBoard(){
        System.out.println(board1.toString());
    }

}

public class Board{

    private int xSize ;
    private int ySize;
    private Cell[][] matrix;
    private Cell[][] matrix2;

    public Board (int x, int y){
        this.xSize=x;
        this.ySize=y;
        this.matrix = new Cell[x+2][y+2]; //add 2 to in order to make a border
        fill();
    }

    private void fill() {
        for (int y = 0; y<this.ySize+2;y++){
            for (int x = 0; x<this.xSize+2; x++){
                this.matrix[x][y] = new Cell(x,y);}
        }
    }

    public void  makeCellAlive (int x, int y){
        this.matrix [x][y].wakeUp();
    }

    public int getXSize(){
        return this.xSize;
    }

    public int getYSize(){
        return this.ySize;
    }

    public Cell[][] getMatrix (){
        return this.matrix;
    }

    public void setMatrix(Cell[][] newMatrix){
        this.matrix = newMatrix;
    }

    public void playRound(Board nextBoard){
        int nONeighbours;
        for (int x = 1; x <this.xSize-1;x++){
            for (int y = 1; y< this.ySize-1; y++){
                nONeighbours = getNONeighbours(x,y);
                nextBoard.matrix[x][y].setNONeighbours(nONeighbours);
            }
        }

        for (int x = 1; x <this.xSize-1;x++){
            for (int y = 1; y< this.ySize-1; y++){
                playGame(x,y, nextBoard);
            }
        }
    }
    public Cell getCell(int x, int y){
        return this.matrix[x][y];
    }

    private void playGame(int x, int y, Board nextBoard) {
        Cell cell = nextBoard.getCell(x,y);
        int neighbours =cell.getNONeighbours();

        if (neighbours == 2) {
            return;
        }

        if (neighbours == 3) {
            if (cell.isAlive()){
                return ;
            } else {
                nextBoard.getCell(x,y).wakeUp();
            }
        }
        if (neighbours < 2 ) {
            nextBoard.getCell(x,y).kill();
            return;
        }
        if (neighbours >3){
            nextBoard.matrix[x][y].kill();
            return;
        }
    }

    private int getNONeighbours(int x, int y){
        int counter = 0;
        if (matrix[x-1][y-1].isAlive() ){
            counter +=1;
        }
        if (matrix[x][y-1].isAlive()){
            counter +=1;
        }
        if (matrix[x+1][y-1].isAlive()){
            counter +=1;
        }
        if (matrix[x-1][y].isAlive()){
            counter +=1;
        }
        if (matrix[x+1][y].isAlive()){
            counter +=1;
        }
        if (matrix[x-1][y+1].isAlive()){
            counter +=1;
        }
        if (matrix[x][y+1].isAlive()){
            counter +=1;
        }
        if (matrix[x+1][y+1].isAlive()){
            counter +=1;
        }
        return counter;
    }

    @Override
    public String toString(){
        System.out.print("\033[2J\033[;H");
        String returnString = "";

        for (int i = 1; i<this.xSize+1;i++){
            returnString+="\n";
            for (int j = 1; j<this.ySize+1; j++){

                if (this.matrix[i][j].isAlive()){
                    returnString += "* ";
                }else{ returnString +=". ";}
            }
        }
        return returnString;
    }
}

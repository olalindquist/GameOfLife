public class Board{

    private int xSize ;
    private int ySize;
    private Cell[][] matrix;
    private Cell[][] matrix2;


    public Board (int x, int y){

        this.xSize=x;
        this.ySize=y;
        this.matrix = new Cell[x+2][y+2]; //add to in order to make a border

        fill();


    }
    public Cell[][] getMatrix (){
        return this.matrix;

    }

    public void setMatrix(Cell[][] newMatrix){
        this.matrix = newMatrix;

    }
    public void update(Board nextField){

        for (int x = 1; x <this.xSize-1;x++){
            for (int y = 1; y< this.ySize-1; y++){
                int nONeighbours = getNONeighbours(x,y);
                nextField.matrix[x][y].setNONeighbours(nONeighbours);
            }
    }
           for (int x = 1; x <this.xSize-1;x++){
            for (int y = 1; y< this.ySize-1; y++){
                playGame(x,y, nextField);
            }

    }
    }
    public Cell getCell(int x, int y){

        return this.matrix[x][y];
    }
    private void playGame(int x, int y, Board nextField) {

        Cell cell = nextField.getCell(x,y);
        int neighbours =cell.getNONeighbours();

        if (neighbours == 2) {

            return;
        }

        if (neighbours==3 ) {

            if (cell.isAlive()){

                return ;
            } else {
                nextField.getCell(x,y).wakeUp();
            }
        }
            if (neighbours <2 ) {
                nextField.getCell(x,y).kill();
                return;
            }
            if (neighbours >3){
                nextField.matrix[x][y].kill();
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
        if (matrix[x+1][x+1].isAlive()){
            counter +=1;
        }


        return counter;




    }
    @Override
    public String toString(){
        System.out.print("\033[2J\033[;H");
        String returnString = "";
        for (int i = 1; i<this.ySize-1;i++){
                returnString+="\n";
            for (int j = 1; j<this.xSize-1; j++){
                if (this.matrix[i][j].isAlive()){
                    returnString += "* ";
                        }else{ returnString +=". ";}
            }
        }
        return returnString;
    }

    private void fill() {
        for (int x = 0; x<this.ySize;x++){
            for (int y = 0; y<this.xSize; y++){
                this.matrix[x][y] = new Cell(x,y);
            }
        }
    }
    public void  makeCellAlive (int x, int y){
        this.matrix [x][y].wakeUp();
      }




}

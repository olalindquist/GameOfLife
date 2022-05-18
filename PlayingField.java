public class PlayingField{

    private int xSize ;
    private int ySize;
    private Cell[][] matrix;

    public PlayingField (int x, int y){

        this.xSize=x;
        this.ySize=y;
        this.matrix = new Cell[x][y];

    }

    @Override
    public String toString(){
        String returnString = "";
        for (int i = 0; i<this.ySize;i++){
                returnString+="\n";
            for (int j = 0; j<this.xSize; j++){
                 returnString+="*";
            }
                    }
        return returnString;
    }
    }

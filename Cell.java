public class Cell{

    private int  xCoordinate;
    private int yCoodinate;
    private int nONeighbours;
    private boolean alive;

    public Cell(int x,int y){
        this.xCoordinate =x;
        this.yCoodinate =y;
        this.alive = false;

    }
    public int getNONeighbours(){
        return this.nONeighbours;
    }
    public void setNONeighbours(int n){
        this.nONeighbours = n;
    }
    public boolean isAlive(){

        return this.alive;

    }
    public void wakeUp(){
        this.alive = true;
    }
    public void kill(){
        this.alive = false;

    }






}

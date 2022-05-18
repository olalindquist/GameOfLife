import  java.util.concurrent.TimeUnit;

public class GameOfLife {

    public static void switchFields(Board field1, Board field2){
        field1.setMatrix(field2.getMatrix());
    }
public static void main(String[] args) throws InterruptedException{
    boolean gameIsOn = true;

    Board field1 = new Board(15,15);
    Board field2 = new Board(15,15);
    field1.makeCellAlive(5,5);
    field2.makeCellAlive(5,5);
    field1.makeCellAlive(5,6);
    field2.makeCellAlive(5,6);
    field1.makeCellAlive(5,7);
    field2.makeCellAlive(5,7);
    field1.makeCellAlive(6,5);
    field2.makeCellAlive(6,5);


    while (gameIsOn)

           {
            System.out.println(field1);
            field1.update(field2);
            switchFields(field1, field2);
            System.out.println(field1);
            TimeUnit.MILLISECONDS.sleep(100);
           }


}
}

import junit.framework.TestCase;
import org.junit.*;
import static org.junit.Assert.*;

public class Tests extends TestCase {

    /*
      Test Cell
    */

    @Test
    public void test_cellNeighbours1(){
        Cell c1 = new Cell(1,1);
        c1.setNONeighbours(4);
        assertTrue(c1.getNONeighbours() == 4);
    }

    @Test
    public void test_cellDead() {
        Cell c1 = new Cell(1,1);
        assertFalse(c1.isAlive());
    }

    @Test
    public void test_isDead(){
        Cell c1 = new Cell(1,1);
        assertFalse(c1.isAlive());
    }

    @Test
    public void test_wakeUp(){
        Cell c1 = new Cell(1,1);
        c1.wakeUp();
        assertTrue(c1.isAlive());
    }

    @Test
    public void test_kill(){
        Cell c1 = new Cell(1,1);
        c1.wakeUp();
        c1.kill();
        assertFalse(c1.isAlive());
    }

    /*
      Test Board
    */
    @Test
    public void test_getXsize(){
        Board b = new Board(10,12);
        assertTrue(b.getXSize() ==10);
    }
    @Test
    public void test_getYsize(){
        Board b = new Board(10,12);
        assertTrue(b.getYSize() ==12);
    }

    @Test
    public void test_default_dead(){
        Board b = new Board(5,5);
        assertFalse(b.getCell(4,4).isAlive());
    }

    @Test
    public void test_makeCellAlive(){
        Board b = new Board(5,5);
        b.makeCellAlive(4,4);
        Cell c = b.getCell(4,4);
        assertTrue(c.isAlive());
    }

    @Test
    public void test_kill_lonely_cell(){
        Board b1 = new Board(10,10);

        b1.makeCellAlive(4,4);
        b1.playRound();
        Cell c = b1.getCell(4,4);
        assertFalse(c.isAlive());
    }

    @Test
    public void test_kill_cell_with_one_neighbour(){
        Board b1 = new Board(10,10);

        b1.makeCellAlive(4,4);
        b1.makeCellAlive(4,3);
        b1.playRound();
        Cell c = b1.getCell(4,3);
        assertFalse(c.isAlive());
    }

    @Test
    public void test_survive_two_neighbours() {
        Board b1 = new Board(10,10);

        b1.makeCellAlive(2,2);
        b1.makeCellAlive(3,2);
        b1.makeCellAlive(2,3);
        b1.playRound();
        Cell c = b1.getCell(2,3);
        assertTrue(c.isAlive()) ;
    }

    @Test
    public void test_survive_three_neighbours() {
        Board b1 = new Board(10,10);
        Board b2 = new Board(10,10);
        b1.makeCellAlive(2,2);
        b1.makeCellAlive(3,2);
        b1.makeCellAlive(4,2);
        b1.makeCellAlive(3,3);
        b1.playRound();
        Cell c = b1.getCell(3,3);
        assertTrue(c.isAlive()) ;
    }

    @Test
    public void test_wake_with_three_neighbours(){
        Board b1 = new Board(10,10);
        b1.makeCellAlive(2,2);
        b1.makeCellAlive(3,2);
        b1.makeCellAlive(2,3);
        b1.makeCellAlive(2,4);
        b1.makeCellAlive(3,3);
        b1.playRound();
        Cell c = b1.getCell(3,3);
        assertFalse(c.isAlive());
    }

    @Test
    public void test_kill_if_overpopulated(){
        Board b1 = new Board(10,10);
        b1.makeCellAlive(2,2);
        b1.makeCellAlive(3,2);
        b1.makeCellAlive(2,3);
        b1.playRound();
        Cell c = b1.getCell(3,3);
        assertTrue(c.isAlive());
    }

}

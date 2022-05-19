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
}

/*
///////////////////////////////////////////////////////////////////
    @Test
    public void test_avatarGetPointTest(){
        Avatar a1 = new Avatar("room01", 100);
        int i1 = a1.points();
        assertTrue(i1 == 60);
    }

    @Test
    public void test_avatarMaxWeight(){
      Avatar a1 = new Avatar("room01", 100);
      int i1 = a1.maxWeight();
      assertTrue(i1 == 100);
    }




    @Test
    public void test_enrollAndIsEnrolled() {
      Avatar a1 = new Avatar("room01", 100);
      //RoomMap roomMap = new RoomMap("room.txt");

      //Course course = new Course("cour15; 10; magic; magicbook; 0; 0; 99");
      //a1.enroll(magic);
      //boolean b1 = a1.isEnrolled(magic);
      //assertTrue(b1);
    }
/*
    @Test
    public void passedCourse(){
      Avatar a1 = new Avatar("room01", 100);
      a1.enroll(magic);
      a1.passed();
      boolean b1 = a1.finishedCourses();
      assertTrue(b1);
    }
*/

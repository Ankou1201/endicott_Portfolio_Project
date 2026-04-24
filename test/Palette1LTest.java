import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit test fixture for {@code Palette1L}'s kernel and Standard methods.
 *
 * @author Zoey Endicott
 */
public class Palette1LTest {

    //The following tests are for the add method ------------------------------------------------------
    /**
     * Tests add to empty palette 
     */
    @Test
    public void testAddToEmpty() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        assertEquals(new Palette1L("#FF0000"), p);
    }

    /**
     * Tests add second color to palette
     */
    @Test
    public void testAddTo1() {
        Palette p = new Palette1L("#FF0000");
        p.add("#0000FF");
        assertEquals(2, p.size());
        assertTrue(p.contains("#FF0000"));
        assertTrue(p.contains("#0000FF"));
    }

    /**
     * Tests add third and more
     */
    @Test
    public void testAddToMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        assertEquals(3, p.size());
        assertTrue(p.contains("#FF0000"));
        assertTrue(p.contains("#00FF00"));
        assertTrue(p.contains("#0000FF"));
    }

    //the following tests are for the removeAny method ------------------------------------------------------

    /**
     * Tests removeAny on palette with one color
     */
    @Test
    public void testRemoveAny1() {
        Palette p = new Palette1L("#FF0000");
        String removed = p.removeAny();
        assertEquals("#FF0000", removed);
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests removeAny on palette with two colors
     */
    @Test
    public void testRemoveAny2() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#0000FF");
        String removed = p.removeAny();
        assertTrue(removed.equals("#FF0000") || removed.equals("#0000FF"));
        assertEquals(1, p.size());
        assertFalse(p.contains(removed));
    }

    /**
     * Tests removeAny on palette with many colors — size decreases by 1.
     */
    @Test
    public void testRemoveAnyMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        String removed = p.removeAny();
        assertFalse(p.contains(removed));
        assertEquals(2, p.size());
    }

    //the following tests are for the contains method ------------------------------------------------------
    /**
     * Tests contains on empty palette
     */
    @Test
    public void testContains0() {
        Palette p = new Palette1L();
        assertFalse(p.contains("#FF0000"));
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests contains on palette with one matching color
     */
    @Test
    public void testContains1Match() {
        Palette p = new Palette1L("#FF0000");
        Palette pCopy = new Palette1L("#FF0000");
        assertTrue(p.contains("#FF0000"));
        assertEquals(pCopy, p);
    }

    /**
     * Tests contains on palette with one color, querying absent color.
     */
    @Test
    public void testContains1Miss() {
        Palette p = new Palette1L("#FF0000");
        Palette pCopy = new Palette1L("#FF0000");
        assertFalse(p.contains("#0000FF"));
        assertEquals(pCopy, p);
    }

    /**
     * Tests contains on palette with many colors
     */
    @Test
    public void testContainsManyMatch() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette pCopy = new Palette1L();
        pCopy.add("#FF0000");
        pCopy.add("#00FF00");
        pCopy.add("#0000FF");
        assertTrue(p.contains("#00FF00"));
        assertEquals(pCopy, p);
    }

    /**
     * Tests contains on palette with many colors
     */
    @Test
    public void testContainsManyMiss() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette pCopy = new Palette1L();
        pCopy.add("#FF0000");
        pCopy.add("#00FF00");
        pCopy.add("#0000FF");
        assertFalse(p.contains("#FFFFFF"));
        assertEquals(pCopy, p);
    }

    //the following tests are for the size method ------------------------------------------------------
    /**
     * Tests size on empty palette.
     */
    @Test
    public void testSize0() {
        Palette p = new Palette1L();
        assertEquals(0, p.size());
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests size on palette with one color.
     */
    @Test
    public void testSize1() {
        Palette p = new Palette1L("#FF0000");
        Palette pCopy = new Palette1L("#FF0000");
        assertEquals(1, p.size());
        assertEquals(pCopy, p);
    }

    /**
     * Tests size on palette with many colors.
     */
    @Test
    public void testSizeMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette pCopy = new Palette1L();
        pCopy.add("#FF0000");
        pCopy.add("#00FF00");
        pCopy.add("#0000FF");
        assertEquals(3, p.size());
        assertEquals(pCopy, p);
    }

    //the following tests are for the isEmpty method ------------------------------------------------------

    /**
     * Tests clear on empty palette
     */
    @Test
    public void testClear0() {
        Palette p = new Palette1L();
        p.clear();
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests clear on palette with one color
     */
    @Test
    public void testClear1() {
        Palette p = new Palette1L("#FF0000");
        p.clear();
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests clear on palette with many colors
     */
    @Test
    public void testClearMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        p.clear();
        assertEquals(new Palette1L(), p);
    }
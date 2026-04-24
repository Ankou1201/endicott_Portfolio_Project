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
    
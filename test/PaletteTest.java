import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * JUnit test fixture for {@code Palette}'s secondary methods
 * (layered implementations in {@code PaletteSecondary}).
 *
 * @author Zoey Endicott
 */
public class PaletteTest {
    //The following tests are for the blend method ------------------------------

    /**
     * Tests blend of black and white
     */
    @Test
    public void testBlendBlackWhite() {
        Palette p = new Palette1L();
        String result = p.blend("#000000", "#FFFFFF");
        assertEquals("#7F7F7F", result);
    }

    /**
     * Tests blend of two identical colors, which should return the same color.
     */
    @Test
    public void testBlendSameColor() {
        Palette p = new Palette1L();
        String result = p.blend("#FF0000", "#FF0000");
        assertEquals("#FF0000", result);
    }

    /**
     * Tests blend of two distinct colors
     */
    @Test
    public void testBlendTwoDistinctColors() {
        Palette p = new Palette1L();
        String result = p.blend("#FF0000", "#0000FF");
        assertEquals("#7F007F", result);
    }

    /**
     * Tests blend does not mutate this palette when it's empty
     */
    @Test
    public void testBlendDoesNotMutateEmpty() {
        Palette p = new Palette1L();
        Palette pCopy = new Palette1L();
        p.blend("#FF0000", "#0000FF");
        assertEquals(pCopy, p);
    }

//The following tests are for isEmpty method -------------------------------------------------------
    /**
     * Tests isEmpty on empty palette --> true
     */
    @Test
    public void testIsEmptyZero() {
        Palette p = new Palette1L();
        assertTrue(p.isEmpty());
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests isEmpty with one color (1) --> false
     */
    @Test
    public void testIsEmptyOne() {
        Palette p = new Palette1L("#FF0000");
        Palette pCopy = new Palette1L("#FF0000");
        assertFalse(p.isEmpty());
        assertEquals(pCopy, p);
    }

    /**
     * Tests isEmpty with many colors --> false
     */
    @Test
    public void testIsEmptyMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette pCopy = new Palette1L();
        pCopy.add("#FF0000");
        pCopy.add("#00FF00");
        pCopy.add("#0000FF");
        assertFalse(p.isEmpty());
        assertEquals(pCopy, p);
    }

    //the following test cases are for the remove method -------------------------------------------------------
    /**
     * Tests remove on palette with one color
     */
    @Test
    public void testRemoveOne() {
        Palette p = new Palette1L("#FF0000");
        p.remove("#FF0000");
        assertEquals(new Palette1L(), p); //creates new empty palette
    }
        
    /**
     * Tests remove on palette with two colo
     */
    @Test
    public void testRemoveOneOfTwo() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#0000FF");
        Palette expected = new Palette1L("#FF0000");
        p.remove("#0000FF"); //target color is removed
        assertEquals(expected, p);
    }


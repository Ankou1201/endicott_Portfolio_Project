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
    public void testIsEmpty0() {
        Palette p = new Palette1L();
        assertTrue(p.isEmpty());
        assertEquals(new Palette1L(), p);
    }

    /**
     * Tests isEmpty with one color (1) --> false
     */
    @Test
    public void testIsEmpty1() {
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
     * Tests remove on palette with two color, only one target removed
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
    /**
     * Tests remove on palette with many colors 
     */
    @Test
    public void testRemoveOneOfMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette expected = new Palette1L();
        expected.add("#FF0000");
        expected.add("#0000FF");
        p.remove("#00FF00");
        assertEquals(expected, p);
    }

    //the following test cases are for toString method -------------------------------------------------------
    /**
     * Tests toString on empty palette
     */    
    @Test
    public void testToString0() {
        Palette p = new Palette1L();
        Palette pCopy = new Palette1L();
        assertEquals("{}", p.toString());
        assertEquals(pCopy, p);
    }
    /**
     * Tests toString on palette with one color
     */
    @Test
    public void testToString1() {
        Palette p = new Palette1L("#FF0000");
        Palette pCopy = new Palette1L("#FF0000");
        String result = p.toString();
        assertTrue(result.contains("#FF0000"));
        assertTrue(result.startsWith("{"));
        assertTrue(result.endsWith("}"));
        assertEquals(pCopy, p);
    }
    /**
     * Tests toString on palette with many colors
     */
    @Test
    public void testToStringMany() {
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");
        Palette pCopy = new Palette1L();
        pCopy.add("#FF0000");
        pCopy.add("#00FF00");
        pCopy.add("#0000FF");
        String result = p.toString();
        assertTrue(result.contains("#FF0000"));
        assertTrue(result.contains("#00FF00"));
        assertTrue(result.contains("#0000FF"));
        assertEquals(pCopy, p);
    }
    //the following test cases are for the equals method -------------------------------------------------------
    /**
     * Tests equals on two empty palettes
     */
    @Test
    public void testEquals0() {
        Palette p1 = new Palette1L();
        Palette p2 = new Palette1L();
        assertEquals(p1, p2);
    }

    /**
     * Tests equals on two palettes each with one matching color
     */
    @Test
    public void testEquals1() {
        Palette p1 = new Palette1L("#FF0000");
        Palette p2 = new Palette1L("#FF0000");
        assertEquals(p1, p2);
    }

    /**
     * Tests equals on two palettes with many matching colors
     */
    @Test
    public void testEqualsMany() {
        Palette p1 = new Palette1L();
        p1.add("#FF0000");
        p1.add("#00FF00");
        p1.add("#0000FF");
        Palette p2 = new Palette1L();
        p2.add("#0000FF");
        p2.add("#FF0000");
        p2.add("#00FF00");
        assertEquals(p1, p2);
    }

    /**
     * Tests equals returns false when one palette has one color
     */
    @Test
    public void testEqualsNotEqualOneVsZero() {
        Palette p1 = new Palette1L("#FF0000");
        Palette p2 = new Palette1L();
        assertFalse(p1.equals(p2));
    }

    /**
     * Tests equals does not mutate either palette (many colors).
     */
    @Test
    public void testEqualsDoesNotMutateMany() {
        Palette p1 = new Palette1L();
        p1.add("#FF0000");
        p1.add("#00FF00");
        Palette p2 = new Palette1L();
        p2.add("#FF0000");
        p2.add("#00FF00");
        Palette p1Copy = new Palette1L();
        p1Copy.add("#FF0000");
        p1Copy.add("#00FF00");
        Palette p2Copy = new Palette1L();
        p2Copy.add("#FF0000");
        p2Copy.add("#00FF00");
        p1.equals(p2);
        assertEquals(p1Copy, p1);
        assertEquals(p2Copy, p2);
    }
}

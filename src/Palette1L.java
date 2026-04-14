import java.util.ArrayList;
import java.util.List;

/**
 * {@code Palette} represented as an {@code ArrayList<String>} of uppercase hex
 * color strings, with implementations of primary methods.
 *
 * <p>
 * Convention:
 * this.colors is not null
 * no two entries in this.colors are equal (no duplicates)
 * every string in this.colors starts with '#', has length 7,
 * and characters [1..6] are uppercase hex digits [0-9A-F]
 *
 * <p>
 * Correspondence:
 * this = the set of hex color strings stored in this.colors
 *
 * @author Zoey Endicott
 */
public class Palette1L extends PaletteSecondary {

    /*
     * Private members
     */

    /**
     * Representation of {@code this}.
     */
    private List<String> colors;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.colors = new ArrayList<String>();
    }

    /*
     * Constructors
     */

    /**
     * No-argument constructor.
     */
    public Palette1L() {
        this.createNewRep();
    }

    /**
     * Constructor from an initial hex color string.
     *
     * @param hexColor
     *            the initial color to add
     * @requires
     *            hexColor starts with '#' and |hexColor| = 7 and hexColor[1..6]
     *            are valid hex characters [0-9A-Fa-f]
     */
    public Palette1L(String hexColor) {
        this.createNewRep();
        this.add(hexColor);
    }

    /*
     * Standard methods
     */

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final Palette newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void transferFrom(Palette source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Palette1L : ""
                + "Violation of: source is of dynamic type Palette1L";

        Palette1L localSource = (Palette1L) source;
        this.colors = localSource.colors;
        localSource.createNewRep();
    }

    /*
     * Kernel methods
     */

    @Override
    public void add(String hexColor) {
        assert hexColor != null : "Violation of: hexColor is not null";
        assert hexColor.length() == 7 : "Violation of: |hexColor| = 7";
        assert hexColor.charAt(0) == '#' : "Violation of: hexColor starts with '#'";

        this.colors.add(hexColor.toUpperCase());
    }

    @Override
    public String removeAny() {
        assert this.colors.size() > 0 : "Violation of: |this| > 0";

        return this.colors.remove(0);
    }

    @Override
    public boolean contains(String hexColor) {
        assert hexColor != null : "Violation of: hexColor is not null";

        return this.colors.contains(hexColor.toUpperCase());
    }

    @Override
    public int size() {
        return this.colors.size();
    }

}
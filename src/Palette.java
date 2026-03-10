/**
 * Enhanced interface for the {@code Palette} component, layering additional
 * convenience methods on top of {@link PaletteKernel}.
 *
 * <p>All methods here can be implemented solely using kernel and
 * {@code Standard} methods.
 *
 * @author Zoey
 * @mathmodel inherited from {@link PaletteKernel}
 */
public interface Palette extends PaletteKernel {

    /**
     * Blends two hex colors by averaging each RGB channel.
     *
     * @param color1
     *            the first hex color string
     * @param color2
     *            the second hex color string
     * @return the blended hex color string in the format {@code #RRGGBB}
     * @requires
     *  <pre>
     *  color1 and color2 each start with '#' and have length 7 and
     *  color1[1..6] and color2[1..6] are valid hex characters [0-9A-Fa-f]
     *  </pre>
     * @ensures
     *  <pre>
     *  blend = "#" + toHex((red(color1)+red(color2))/2)
     *              + toHex((green(color1)+green(color2))/2)
     *              + toHex((blue(color1)+blue(color2))/2)
     *  </pre>
     */
    String blend(String color1, String color2);

    /**
     * Reports whether this palette is empty.
     *
     * @return true iff this palette contains no colors
     * @ensures
     *  <pre>
     *  isEmpty = (|this| = 0)
     *  </pre>
     */
    boolean isEmpty();

    /**
     * Removes all occurrences of {@code hexColor} from this palette.
     *
     * @param hexColor
     *            the hex color string to remove
     * @updates this
     * @requires
     *  <pre>
     *  hexColor.toUpperCase() is in this
     *  </pre>
     * @ensures
     *  <pre>
     *  this = #this \ {hexColor.toUpperCase()}
     *  </pre>
     */
    void remove(String hexColor);

}
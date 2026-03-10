import components.standard.Standard;

public interface PaletteKernel {
 /**
     * Adds {@code hexColor} to this palette.
     *
     * @param hexColor
     *            the hex color string to add
     * @aliases reference {@code hexColor}
     * @updates this
     * @requires
     *  <pre>
     *  hexColor starts with '#' and |hexColor| = 7 and
     *  hexColor[1..6] are all valid hex characters [0-9A-Fa-f]
     *  </pre>
     * @ensures
     *  <pre>
     *  this = #this union {hexColor.toUpperCase()}
     *  </pre>
     */
    void add(String hexColor);
    /**
     * Removes and returns an arbitrary color from this palette.
     *
     * @return the removed hex color string
     * @updates this
     * @requires
     *  <pre>
     *  |this| > 0
     *  </pre>
     * @ensures
     *  <pre>
     *  removeAny is in #this and
     *  this = #this \ {removeAny}
     *  </pre>
     */
    String removeAny();
}

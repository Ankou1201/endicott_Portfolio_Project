/**
 * A theme generator that uses a {@code Palette} to build a coordinated color
 * scheme from a single base color by blending it with fixed light and dark
 * anchor colors.
 * 
 * This project is inspired by the following:
 * Rino de Boer. “Building a Color Palette Generator Website (Vibe Coding).” 
 * YouTube, 21 May 2025, www.youtube.com/watch?v=zo_fRAblVto.
 * 

 *
 * <p>
 * This class demonstrates using {@code Palette} as an internal representation
 * of a more complex component.
 *
 * 
 * @author Zoey Endicott
 */
public final class ThemeGenerator {

    /**
     * A fixed light anchor color for generating tints.
     */
    private static final String LIGHT = "#FFFFFF";

    /**
     * A fixed dark anchor color for generating shades.
     */
    private static final String DARK = "#000000";

    /**
     * The generated theme palette.
     */
    private Palette theme;

    /**
     * Constructs a new {@code ThemeGenerator} from the given base color.
     * Generates a tint (base blended with white), the base itself, and a shade
     * (base blended with black).
     *
     * @param baseColor
     *            the hex color string to build the theme around
     * @requires
     *            baseColor starts with '#' and |baseColor| = 7 and
     *            baseColor[1..6] are valid hex characters [0-9A-Fa-f]
     */
    public ThemeGenerator(String baseColor) {
        this.theme = new Palette1L();

        Palette helper = new Palette1L();

        String tint = helper.blend(baseColor, LIGHT);
        String shade = helper.blend(baseColor, DARK);

        this.theme.add(tint);
        this.theme.add(baseColor);
        this.theme.add(shade);
    }

    /**
     * Reports whether the given color is part of this theme.
     *
     * @param hexColor
     *            the hex color string to look for
     * @return true iff hexColor is in this theme
     */
    public boolean inTheme(String hexColor) {
        return this.theme.contains(hexColor);
    }

    /**
     * Reports the number of colors in this theme.
     *
     * @return the number of colors in the theme palette
     */
    public int size() {
        return this.theme.size();
    }

    /**
     * Returns a string representation of this theme.
     *
     * @return a string showing all colors in the theme palette
     */
    @Override
    public String toString() {
        return "Theme: " + this.theme;
    }

    /**
     * Main method demonstrating {@code ThemeGenerator} usage.
     *
     * @param args
     *            the command line arguments (unused)
     */
    public static void main(String[] args) {

        //based on red
        ThemeGenerator redTheme = new ThemeGenerator("#FF0000");
        System.out.println(redTheme);
        System.out.println("Theme size: " + redTheme.size());
        System.out.println("Contains #FF0000: " + redTheme.inTheme("#FF0000"));

        //based on blue
        ThemeGenerator blueTheme = new ThemeGenerator("#0000FF");
        System.out.println(blueTheme);

        //based on a custom
        ThemeGenerator brandTheme = new ThemeGenerator("#4A90D9");
        System.out.println(brandTheme);
    }
}
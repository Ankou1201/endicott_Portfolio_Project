/**
 * A simple demonstration of the {@code Palette} component's basic operations,
 * including adding colors, blending, checking membership, and removing colors.
 *
 * @author Zoey Endicott
 */
public final class PaletteDemo {

    /**
     * Private constructor to prevent instantiation.
     */
    private PaletteDemo() {
    }

    /**
     * Main method demonstrating basic {@code Palette} operations.
     *
     * @param args
     *            the command line arguments (unused)
     */
    public static void main(String[] args) {

        //create new, add some colors
        Palette p = new Palette1L();
        p.add("#FF0000");
        p.add("#00FF00");
        p.add("#0000FF");

        System.out.println("Initial palette: " + p);
        System.out.println("Size: " + p.size());
        System.out.println("Is empty: " + p.isEmpty());

        //checks for contains
        System.out.println("Contains #FF0000: " + p.contains("#FF0000"));
        System.out.println("Contains #FFFFFF: " + p.contains("#FFFFFF"));

        //blend and print(add the blended)
        String blended = p.blend("#FF0000", "#0000FF");
        System.out.println("Blend of #FF0000 and #0000FF: " + blended);
        p.add(blended);
        System.out.println("Palette after adding blend: " + p);

        //remove
        p.remove("#00FF00");
        System.out.println("Palette after removing #00FF00: " + p);

        //clear
        p.clear();
        System.out.println("Palette after clear: " + p);
        System.out.println("Is empty: " + p.isEmpty());
    }
}
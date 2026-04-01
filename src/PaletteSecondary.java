/**
 * Layered implementations of secondary methods for {@code Palette}.
 *
 * @author Zoey Endicott
 */
public abstract class PaletteSecondary implements Palette {

    /*
     * Common methods
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Palette temp = this.newInstance();

        while (this.size() > 0) {
            String color = this.removeAny();
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(color);
            temp.add(color);
        }

        //Restore this from temp
        while (temp.size() > 0) {
            this.add(temp.removeAny());
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Palette)) {
            return false;
        }

        Palette other = (Palette) obj;

        if (this.size() != other.size()) {
            return false;
        }

        // Check that every color in this is in other, and vice versa
        Palette temp = this.newInstance();
        boolean equal = true;

        while (this.size() > 0) {
            String color = this.removeAny();
            if (!other.contains(color)) {
                equal = false;
            }
            temp.add(color);
        }

        //Restore this from temp
        while (temp.size() > 0) {
            this.add(temp.removeAny());
        }

        return equal;
    }

    @Override
    public int hashCode() {
        // Not implemented; palette equality is order-independent
        return 0;
    }

    /*
     * Secondary methods -----------------------------------------------
     */

    @Override
    public String blend(String color1, String color2) {
        assert color1 != null : "Violation of: color1 is not null";
        assert color2 != null : "Violation of: color2 is not null";
        assert color1.length() == 7 && color1.charAt(0) == '#'
                : "Violation of: color1 is a valid hex color";
        assert color2.length() == 7 && color2.charAt(0) == '#'
                : "Violation of: color2 is a valid hex color";

        // Parse each RGB
        int r1 = Integer.parseInt(color1.substring(1, 3), 16);
        int g1 = Integer.parseInt(color1.substring(3, 5), 16);
        int b1 = Integer.parseInt(color1.substring(5, 7), 16);

        int r2 = Integer.parseInt(color2.substring(1, 3), 16);
        int g2 = Integer.parseInt(color2.substring(3, 5), 16);
        int b2 = Integer.parseInt(color2.substring(5, 7), 16);

        // Average
        int r = (r1 + r2) / 2;
        int g = (g1 + g2) / 2;
        int b = (b1 + b2) / 2;

        // Format back to #RRGGBB
        return String.format("#%02X%02X%02X", r, g, b);
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void remove(String hexColor) {
        assert hexColor != null : "Violation of: hexColor is not null";
        assert this.contains(hexColor.toUpperCase())
                : "Violation of: hexColor.toUpperCase() is in this";

        //remove one occurrence of hexColor by moving all colors to a temp palette
        Palette temp = this.newInstance();
        String target = hexColor.toUpperCase();
        boolean removed = false;

        while (this.size() > 0) {
            String color = this.removeAny();
            if (!removed && color.equals(target)) {
                removed = true;
            } else {
                temp.add(color);
            }
        }

        //restore this from temp
        while (temp.size() > 0) {
            this.add(temp.removeAny());
        }
    }

}
import java.util.ArrayList; //used array list to store the colors in the palette
import java.util.List;
import java.util.Random; //used random to generate random colors for the palette

/*
The external resources used in this project listed below:
https://stackoverflow.com/questions/3607858/convert-a-rgb-color-value-to-a-hexadecimal-string
https://www.geeksforgeeks.org/dsa/convert-the-given-rgb-color-code-to-hex-color-code/
 */


/**
 * Proof-of-Concept (MVP) for a Palette component.
 *
 * Representation: a List of normalized hex colors (format: #RRGGBB, uppercase).
 * This MVP demonstrates feasibility of kernel + secondary methods in one file
 *
 */

public class PalettePOC {
    
    private final List<String> colors; //store the colors in the palette
    public PalettePOC() {//constructor
        this.colors = new ArrayList<>(); //initialize the list of colors
    }
    //---Kernel methods below---//
    /**
     * Adds a hexadecimal color to the palette.
     *
     * Current MVP validation: only adds the color if it starts with '#'.
     * The stored color is converted to uppercase.
     *
     * @param hexColor
     *            hex color string (expected like "#RRGGBB")
     */
    public void addColor(String hexColor) { 
        if(hexColor.startsWith("#")){
            this.colors.add(hexColor.toUpperCase()); //add the color to the palette, convert to uppercase
        }

    }
    /**
     * Removes and returns the last color (serves as a simple removeAny).
     *
     * @return the removed color if available; otherwise returns null if the
     *         palette is empty
     */
    public String removeAny(){
        if(this.colors.size() > 0){ //check if there are any colors in the palette
            return this.colors.remove(this.colors.size()-1); //remove and return the last color in the palette
        }
        return null; //if no color at here
    }
    /**
     * Reports the number of colors currently stored in the palette.
     *
     * @return number of colors
     */
    public int size() {
        return this.colors.size(); 
    }
//---Secondary methods below---//
    /**
     * Blends two colors by converting hex to RGB, averaging each channel,
     * then converting back to hex.
     *
     * @param color1
     *            first color (expected like "#RRGGBB")
     * @param color2
     *            second color (expected like "#RRGGBB")
     * @return blended color in hex format like "#RRGGBB" (uppercase)
     */
    public String blendColors(String color1, String color2) {
        //external resource used for hex to RGB conversion: https://stackoverflow.com/questions/3607858/convert-a-rgb-color-value-to-a-hexadecimal-string
        int r1 = Integer.parseInt(color1.substring(1, 3), 16);
        int g1 = Integer.parseInt(color1.substring(3, 5), 16);
        int b1 = Integer.parseInt(color1.substring(5, 7), 16);

        int r2 = Integer.parseInt(color2.substring(1, 3), 16);
        int g2 = Integer.parseInt(color2.substring(3, 5), 16);
        int b2 = Integer.parseInt(color2.substring(5, 7), 16);

        
        int ravg = (r1 + r2) / 2;
        int gavg = (g1 + g2) / 2;
        int bavg = (b1 + b2) / 2;

        //back to hex
        return String.format("#%02X%02X%02X", ravg, gavg, bavg);
    /**
     * Checks whether the palette contains the given color.
     *
     * @param hexColor
     *            hex color string (expected like "#RRGGBB")
     * @return true if present; false otherwise
     */
    public boolean containsColor(String hexColor) {
        return this.colors.contains(hexColor.toUpperCase());
}
    /*
    Clears all the colors from the palette.
     */
    public void clear() {
        this.colors.clear();
    }



    public static void main(String[] args) {
        System.out.println("=== Palette Component Proof-of-Concept ===");

        //create and add base colors to the palette
        PalettePOC myPalette = new PalettePOC();
        String red = "#FF0000";
        String blue = "#0000FF";
        String green = "#00FF00";

        myPalette.add(red);
        myPalette.add(blue);
        myPalette.add(green);

        System.out.println("Added base colors: Red (" + red + ") and Blue (" + blue + ") and Green (" + green + ")");
        System.out.println("Current palette size: " + myPalette.size());

        //blend the two colors and display the result
        System.out.println("\nBlending colors...");
        String purple = myPalette.blend(red, blue);
        System.out.println("Blend result (purple): " + purple);

        myPalette.add(purple);

        //checks contains
        if (myPalette.contains(purple)) {
            System.out.println("Successfully saved the blended color to the palette.");
        }

        String removed = myPalette.removeAny();
        System.out.println("\nRemoved color: " + removed);
        System.out.println("Remaining number of colors: " + myPalette.size());
}
    }

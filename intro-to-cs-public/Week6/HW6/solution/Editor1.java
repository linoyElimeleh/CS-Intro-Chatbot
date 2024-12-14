import java.awt.Color;

/**
 * Demonstrates three basic image processing operations that are featured by Runigram.java.
 * The program recieves two command-line arguments: a string representing the name of the PPM file
 * of a source image, and one of the strings "fh", "fv", or "gs". The program creates a new image
 * which is either the horizontally flipped version of the source image ("fh"), or the vertically
 * flipped version of the source image ("fv"), or the grayscaled version of the source image ("gs"). 
 * The program then displays the original image, waits 3 seconds, and then displays the processed
 * image, in the same window ("canvass"). 
 * For example, to create a grayscale version of thor.ppm, use: java Editor1 thor.ppm gs
 */
public class Editor1 {

	public static void main (String[] args){
		String fileName = args[0];
		String action = args[1];
		// Reads the input image and creates a new output image
		Color[][] imageIn = Runigram.read(fileName);	
		Color[][] imageOut = null;	
		// Applies the specified image processing function										
		if (action.equals("fh")) {
			imageOut = Runigram.flippedHorizontally(imageIn);
		} else if (action.equals("fv")) {
			imageOut = Runigram.flippedVertically(imageIn);
		} else if (action.equals("gs")) {
			imageOut = Runigram.grayScaled(imageIn);
		}
		// Creates a canvas in which both images will be displayed, one after the other.
		// (Both images have the same dimensions).
		Runigram.setCanvas(imageIn);
		// Displays the input image, pauses for a little while, and then displays the output image.
		Runigram.display(imageIn);
		StdDraw.pause(3000); // Waits 3000 milliseconds
		Runigram.display(imageOut);							
	}
}
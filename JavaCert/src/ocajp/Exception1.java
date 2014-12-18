package ocajp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exception1 {

    public static void main(String[] args) {
        System.out.println(parseFloat("er"));
    }

    public static float parseFloat(String s) {
        float f = 0.0f;
        try {
            f = Float.valueOf(s).floatValue();
            return f;
        } catch (NumberFormatException nfe) {
            f = Float.NaN;
            return f;
        } finally {
            f = 10.0f;
            return f;
        }
    }

    public void validExceptionBlocks() {
        try {
        } catch (Exception e) {
        } // no finally

        try {
        } finally {
        } // no catch

        try {
        } catch (Exception e) {
        } finally {
        }

        // Subclassig not allowed in this.
        try {
            if (4 > 5) {
                throw new IOException();
            }
            if (4 > 3) {
                throw new AssertionError();
            }
        } catch (IOException | AssertionError e) {
        }
    }

}

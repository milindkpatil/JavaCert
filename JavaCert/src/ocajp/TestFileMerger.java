package ocajp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class TestFileMerger {

    public static void main(String args[]) throws IOException {

        File folder = new File("C:\\Java\\JavaCert\\src\\ocajp");
        File[] listOfFiles = folder.listFiles();

        File outFile = new File("C:\\Java\\JavaCert\\doc\\OCAJP.java");

        // if file doesnt exists, then create it
        if (!outFile.exists()) {
            outFile.createNewFile();
        } else {
            outFile.delete();
            outFile.createNewFile();
        }

        FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for (File file : listOfFiles) {
            if (file.isFile()) {

                bw.write("************************************" + file.getName() + "***********************************************");
                bw.write("\n");
                for (String line : Files.readAllLines(file.toPath(), Charset.defaultCharset()) ) {
                    bw.write(line);
                    bw.write("\n");
                }
            }
        }

        bw.close();
        System.out.println("Done.");
    }
}

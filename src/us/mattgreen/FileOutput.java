package us.mattgreen;

import java.io.*;

/**
 * FILE TO BE CREATED
 * @author kpatr
 * @version 1.0.0
 */
public class FileOutput {

    Writer out = null;
    private String fileName;

    /**
     * CONSTRUCTOR TO CREATE THE OUTPUT FILE
     * @param fileName
     */
    public FileOutput(String fileName) {
        this.fileName = fileName;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " "  + e);
        }
    }

    /**
     * STRING TO WRITE TO FILE
     * @param line
     */
    public void fileWrite(String line) {
        try {
            out.write(line+"\n");
        }
        catch(Exception e) {
            System.out.println("File Write Error: " + fileName + " "  + e);
        }
    }

    /**
     * CLOSE THE FILE TO BE WRITTEN TO
     */
    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
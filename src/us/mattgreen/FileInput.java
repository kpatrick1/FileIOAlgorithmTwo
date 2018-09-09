package us.mattgreen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * OPEN FILE FOR READING
 * @author kpatr
 * @version 1.0.0
 */
public class FileInput {

    private BufferedReader in = null;
    private String fileName;

    /**
     * CONSTRUCTOR FOR THE FILE TO READ
     * @param fileName
     */
    public FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }

    /**
     * OUTPUT THE CONTENTS OF THE FILE TO THE SCREEN
     */
    public void fileRead() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
        }
    }

    /**
     * READ THE NEXT LINE OF THE FILE
     * @return STRING OF THE NEXT FILE
     */
    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
            return null;
        }
    }

    /**
     * CLOSE THE FILE TO BE READ FROM
     */
    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
import interfaces.IServerConfigReader;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

/**
 * Takes the text file and converts it into json file
 */
public class JsonConverterClient {
    /**
     * the main program to execute the conversion of text file into json file
     * @param args contains the file path
     */
    public static void main(String[] args) {

        try {
            final Scanner fileInput = new Scanner(System.in);
            System.out.println("Enter file path to parse");
            final String filePath = fileInput.nextLine();

            final IServerConfigReader textFileServerReader = new TextFileServerReader();
            final JSONObject jsonObject = textFileServerReader.getConfig(filePath);

            System.out.println(jsonObject.toString());
        }
        catch (IOException io) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            System.out.println("Failed to process file. More information");
            System.out.println(e.getMessage());
        }
    }
}

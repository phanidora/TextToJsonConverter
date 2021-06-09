package interfaces;

import exceptions.InvalidConfigEntry;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Interface for extension
 */
public interface IServerConfigReader {
    /**
     * This Interface can help us to process different formatted files like csv into json in future
     * @param filePath the file path to the data.text file
     * @return JsonObject
     * @throws IOException if there are any misaligned data in the text file
     * @throws InvalidConfigEntry
     */
    JSONObject getConfig(String filePath) throws IOException, InvalidConfigEntry;
}

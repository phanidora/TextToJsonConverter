import exceptions.InvalidConfigEntry;
import interfaces.IServerConfigReader;
import org.json.JSONObject;
import utils.BooleanUtils;
import utils.FileUtils;
import utils.NumericUtils;

import java.io.IOException;
import java.util.List;

/**
 * class to convert text values into Json values using JSONObject
 */
public class TextFileServerReader implements IServerConfigReader {

    private static final String COMMENT_START_DELIMITER = "#";
    private static final String ATTRIBUTE_DELIMITER = "=";

    /**
     * {@inheritDoc}
     */
    @Override
    public JSONObject getConfig(String filePath) throws IOException, InvalidConfigEntry {
        final JSONObject jsonObject = new JSONObject();
        final List<String> fileContents = FileUtils.getFileContents(filePath);

        for (String line: fileContents) {
            if (canIgnoreLine(line)) {
                continue;
            }
            addValue(jsonObject, line);
        }

        return jsonObject;
    }

    private void addValue(JSONObject jsonObject, String line) throws InvalidConfigEntry {
        final String[] configItems = line.split(ATTRIBUTE_DELIMITER);
        if (configItems.length != 2) {
            throw new InvalidConfigEntry(String.format("The line [%s] is not of the form key = value", line));
        }

        addValue(jsonObject, configItems[0].trim(), configItems[1].trim());
    }

    private void addValue(JSONObject jsonObject, String key, String value) {
        if (BooleanUtils.isBoolean (value)) {
            jsonObject.put(key, BooleanUtils.getValue(value));
        } else if (NumericUtils.isNumeric(value)) {
            jsonObject.put(key, NumericUtils.getValue(value));
        } else {
            jsonObject.put(key, value);
        }
    }

    private boolean canIgnoreLine(String line) {
        return line.isBlank() || line.trim().startsWith(COMMENT_START_DELIMITER);
    }
}

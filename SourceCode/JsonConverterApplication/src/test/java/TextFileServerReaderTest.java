import exceptions.InvalidConfigEntry;
import junit.framework.TestCase;
import org.json.JSONObject;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;

public class TextFileServerReaderTest extends TestCase {

    @Test
    public void testGetConfig() throws InvalidConfigEntry, IOException {

        String expectedResult = "{\"debug_mode\":false,\"cost\":2.56,\"test_mode\":true,\"send_notifications\":true,\"log_file_path\":\"/tmp/logfile.log\",\"host\":\"test.com\",\"server_id\":55331,\"user\":\"user\",\"verbose\":true}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/data.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);

    }

    @Test
    public void testGetConfig_limited_data() throws InvalidConfigEntry, IOException {

        String expectedResult = "{\"cost\":2.56,\"log_file_path\":\"/tmp/logfile.log\",\"host\":\"test.com\",\"server_id\":55331,\"user\":\"user\"}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/datawithLimitedValues.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);
    }

    @Test
    public void testGetConfig_empty_data() throws InvalidConfigEntry, IOException {

        String expectedResult = "{}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/emptydata.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);
    }

    @Test
    public void testGetConfig_boolean_data() throws InvalidConfigEntry, IOException {

        String expectedResult = "{\"debug_mode\":false,\"test_mode\":true,\"send_notifications\":true,\"log_file_path\":\"/tmp/logfile.log\",\"user\":\"user\",\"verbose\":true}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/verifyBoolean.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);
    }

    @Test
    public void testGetConfig_duplicate_data() throws InvalidConfigEntry, IOException {

        String expectedResult = "{\"debug_mode\":false,\"cost\":2.56,\"test_mode\":true,\"send_notifications\":true,\"log_file_path\":\"/tmp/logfile.log\",\"host\":\"test.com\",\"server_id\":55331,\"user\":\"user\",\"verbose\":true}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/duplicatedata.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);
    }

    @Test
    public void testGetConfig_extra_data() throws InvalidConfigEntry, IOException {

        String expectedResult = "{\"debug_mode\":false,\"cost\":2.56,\"test_mode\":true,\"send_notifications\":true,\"log_file_path\":\"/tmp/logfile.log\",\"host\":\"test.com\",\"server_id\":55331,\"user\":\"user\",\"verbose\":true,\"state\":stable}";

        TextFileServerReader textFileServerReader = new TextFileServerReader();
        String path = "src/test/java/utils/files/datawithextravalues.txt";
        JSONObject jsonObject = textFileServerReader.getConfig(path);

        JSONAssert.assertEquals(expectedResult,jsonObject.toString(),true);
    }
}
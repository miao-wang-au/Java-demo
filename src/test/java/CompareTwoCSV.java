//import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
//import com.opencsv.exceptions.CsvException;
//import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class CompareTwoCSV {

    private List<String> readFile(String filePath) throws IOException {
        // Reads file line by line into a List<String>
        return Files.readAllLines(Paths.get(filePath));
    }

    @Test
    public void compareCsvFiles() throws IOException {
        String actualFile = "src/test/resources/actual_result.csv";
        String expectedFile = "src/test/resources/expected_result.csv";

        List<String> actualStrings = readFile(actualFile);
        List<String> expectedStrings = readFile(expectedFile);

        // Check if both CSV files have same number of lines
        Assert.assertEquals(actualStrings.size(), expectedStrings.size(),
                "The twp CSV files have different number of lines.");

        // Compare line by line
        for (int i = 0; i < expectedStrings.size(); i++) 
        {
        	//System.out.println(actualStrings.get(i));
            Assert.assertEquals(actualStrings.get(i).trim(), expectedStrings.get(i).trim(),
                    "There is a mismatch at line " + (i + 1));
        }
        

    }
}

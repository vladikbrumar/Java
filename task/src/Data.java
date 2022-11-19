import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Retrieves and handle data for households
 */
public class Data {
    /**
     * Constructor calls to read, format and write data to file
     * @param inputFile file name of the file to read input data from
     * @param outputFile file name of the file to write output data
     */
    public Data(String inputFile, String outputFile) {
        if(inputFile == null) throw new IllegalArgumentException("Input file must not be null");
        if(outputFile == null) throw new IllegalArgumentException("Output file must not be null");
        this.writeToFile(outputFile, readFile(inputFile));
    }

    /**
     * Read data from given file, each person must start from new line
     * @param filename file name of the file
     * @return list of read lines from file
     */
    private List<String> readFile(String filename) {
        List<String> lines = new ArrayList<String>();

        try {
            File inputFile = new File(filename);
            Scanner fileReader = new Scanner(inputFile);
            String line = "";
            while(fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                lines.add(line);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading");
            e.printStackTrace();
        }

        return lines;
    }

    /**
     * Write formatted data to given file name in the following format:
                Household at address, amount of occupants:
                Each person first name, last name, address, city, state, age
     * @param filename file to write formatted data
     * @param inputData data to be written to file
     */
    private void writeToFile(String filename, List<String> inputData) {
        HashMap<String, Household> households = setHouseholds(inputData);
        try {
            File outputFile = new File(filename);
            FileWriter writer = new FileWriter(outputFile);
            for (String key : households.keySet()) {
                writer.write(households.get(key).toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing");
            e.printStackTrace();
        }
    }

    /**
     * Format address by replacing dots, commas and spaces, and put it to lowercase
     * @param line address to be formatted
     * @return formatted address
     */
    private String formatAddressLine(String line){
        return line
                .toLowerCase()
                .replace(",","")
                .replace(".", "")
                .replace(" ", "");
    }

    /**
     * Set unique households by address and set its members
     * @param inputData given data
     * @return set of unique households by its address
     */
    private HashMap<String, Household> setHouseholds(List<String> inputData) {
        HashMap<String, Household> result = new HashMap<>();
        String[] splitLine;
        String currAddress;

        for(String line : inputData) {
            splitLine = line.replace("\",", "-").replace("\"", "").split("-");
            currAddress = splitLine[2] + splitLine[3] + splitLine[4];
            if(result.isEmpty()) {
                result.put(formatAddressLine(currAddress), new Household(splitLine));
            } else {
                if(!result.containsKey(formatAddressLine(currAddress))) {
                    result.put(formatAddressLine(currAddress), new Household(splitLine));
                } else {
                    result.get(formatAddressLine(currAddress)).addMember(new Person(splitLine[0], splitLine[1], splitLine[5]));
                }
            }
        }
        return result;
    }
}

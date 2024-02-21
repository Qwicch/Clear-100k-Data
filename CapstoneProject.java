
import java.io.*;
import java.util.*;

public class CapstoneProject {
    public static void main(String[] args) throws IOException {
        // Read the input file
        FileReader fileReader = new FileReader("wiki-100k.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Create a set to store unique words
        Set<String> uniqueWords = new LinkedHashSet<>();

        // Read each line from the file
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // Ignore comment lines
            if (!line.startsWith("#!")) {
                // Convert the word to lowercase
                String word = line.toLowerCase();
                // Remove single quote or period from the end of the word
                word = removePunctuation(word);
                // Add the word to the set
                uniqueWords.add(word);
            }
        }

        // Close the file
        bufferedReader.close();

        // Write the output file
        FileWriter fileWriter = new FileWriter("cleaned-wiki-100k.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write the unique words to the output file
        for (String word : uniqueWords) {
            bufferedWriter.write(word + "\n");
        }

        // Close the file
        bufferedWriter.close();







        // Read the cleaned data file
        fileReader = new FileReader("cleaned-wiki-100k.txt");
        bufferedReader = new BufferedReader(fileReader);

        // Create a map to store the words and their positions
        Map<String, Integer> wordMap = new HashMap<>();

        // Read each word from the file
        String word;
        int position = 1;
        while ((word = bufferedReader.readLine()) != null) {
            wordMap.put(word, position);
            position++;
        }

        // Close the file
        bufferedReader.close();

        // Display the total number of words processed
        System.out.println("Total number of words processed: " + wordMap.size());

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        boolean isTrue = true;


        System.out.println("""                  
                        _____
                       /    /|_ ___________________________________________
                      /    // /|                                          /|
                     (====|/ //   An apple a day...            _QP_      / |
                      (=====|/     keeps the teacher at bay   (  ' )    / .|
                     (====|/                                   \\__/    / /||
                    /_________________________________________________/ / ||
                    |  _____________________________________________  ||  ||
                    | ||                                            | ||
                    | ||                                            | ||
                    | |                                             | |
                    
                    WELCOME TO MY 100K MOST COMMON WORDS CAPSTONE PROJECT IN ORDER
                    I HOPE YOU WILL ENJOY USING IT, I FILLED THIS CODE WITH PURE LOVE
                    SINCERELY,
                    ILMIR KIREEV""");




        // User interface loop
        while (isTrue) {


            System.out.println("\nChoose an option:");
            System.out.println("1. Search for a word");
            System.out.println("2. Search for a numerical position");
            System.out.println("3. Exit");


            int choice;
            try {
                // Get user's choice
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        // Search for a word
                        System.out.println("Enter the word to search:");
                        String searchWord = scanner.next().toLowerCase();

                        if(Character.isDigit(searchWord.charAt(0)) &&
                                Character.isDigit(searchWord.charAt(searchWord.length() - 1))) {
                            System.out.println("IT'S A NUMBER NOT A WORD, USE SECTION TWO");
                        } else {
                            Integer searchPosition = wordMap.get(searchWord);
                            if (searchPosition != null) {
                                System.out.println("The word \"" + searchWord + "\" is at position: " + searchPosition);
                            } else {
                                System.out.println("The word \"" + searchWord + "\" is not found.");
                            }
                        }
                        break;
                    case 2:
                        // Search for a numerical position
                        System.out.println("Enter the numerical position to search:");
                        int searchPositionInput = scanner.nextInt();

                        if (searchPositionInput >= 1 && searchPositionInput <= wordMap.size()) {
                            String searchWordPosition = getKeyByValue(wordMap, searchPositionInput);
                            System.out.println("The word at position " + searchPositionInput + " is: " + searchWordPosition);
                        } else {
                            System.out.println("Invalid position.");
                        }
                        break;
                    case 3:
                        // Exit the program
                        System.out.println("Exiting the program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        isTrue = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please try again.");
                isTrue = false;
            }

        }
    }

    public static String removePunctuation(String word) {
        while (word.startsWith(".") || word.endsWith(".") ||
                word.startsWith("'") || word.endsWith("'") || word.startsWith(" ")) {

            if (word.startsWith(".")) {
                word = word.substring(1);
            }
            if (word.endsWith(".")) {
                word = word.substring(0, word.length() - 1);
            }
            if (word.startsWith("'")) {
                word = word.substring(1);
            }
            if (word.endsWith("'")) {
                word = word.substring(0, word.length() - 1);
            }

            if (word.startsWith(" ")) {
                word = word.substring(1);
            }
        }
        return word;
    }

    // Helper method to get the key based on a value in the map
    private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
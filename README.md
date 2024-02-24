# 100k unique words Project

This project is a Java program that reads a text file containing a list of words and performs two tasks:

- Task 1: Write a new file with only the unique words in the list.
- Task 2: Allow the user to search for a word or a numerical position in the list.

## Input and Output Files

The input file for this project is `wiki-100k.txt`, which contains 100,000 words extracted from Wikipedia articles. The output file for task 1 is `cleaned-wiki-100k.txt`, which contains the unique words from the input file, one per line. The output file for task 2 is not generated by the program, but the results of the user's search are displayed on the console.

## How to Run the Program

To run the program, you need to have Java installed on your system. You can download Java from [here](https://www.java.com/en/download/).

To compile the program, open a terminal or command prompt and navigate to the folder where the `CapstoneProject.java` file is located. Then, type the following command:

```
javac CapstoneProject.java
```

To execute the program, type the following command:

```
java CapstoneProject
```

The program will perform the following steps:

- Read the input file `wiki-100k.txt`.
- Create a set to store unique words and a map to store words and their positions.
- Convert the words to lowercase and remove punctuation marks.
- Add the words to the set and the map.
- Write the unique words to the output file `cleaned-wiki-100k.txt`.
- Display the total number of words processed.
- Prompt the user to choose an option:
    - Option 1: Search for a word. The user can enter a word to search and the program will display the position of the word in the list, or a message if the word is not found. The word is case-insensitive and punctuation marks are ignored.
    - Option 2: Search for a numerical position. The user can enter a numerical position to search and the program will display the word at that position in the list, or a message if the position is invalid. The position must be between 1 and 99,999.
    - Option 3: Exit the program. The program will terminate and close the scanner.
- Repeat the search as many times as the user wants, until they choose to exit the program.

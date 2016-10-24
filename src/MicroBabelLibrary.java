/**
 * Микро Вавилонская Библиотека с рэндом-генератором
 *
 * Created by Denis on 24.10.2016.
 */

import java.util.*;

public class MicroBabelLibrary {
    public static void main(String[] args) {

        char[] alphabet = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ы','ъ','э','ю','я',' '};
        int alphabetLength = alphabet.length;
        int bookSize = 5;
        int nextChar;
        char[] newBook = new char[bookSize];
        String newBookStr;
        String[] searchStrings = {"я"};
        boolean run = true;
        long runCount = 1;
        Random random = new Random();

        int searchStringsLength = searchStrings.length;

        while (run) {
            for (int i = 0; i < bookSize; i++) {
                nextChar = random.nextInt(alphabetLength);
                newBook[i] = alphabet[nextChar];
            }
            newBookStr = new String(newBook);
            System.out.println(newBook);
            for (int wordIndex = 0; wordIndex < searchStringsLength; wordIndex++) {
                for (int x = 0; x <= bookSize - searchStrings[wordIndex].length(); x++)
                    //if (searchString.compareTo(new String(newBook)) == 0){
                    if (newBookStr.regionMatches(x, searchStrings[wordIndex], 0, searchStrings[wordIndex].length())) {
                        System.out.println("Нашел слово \"" + searchStrings[wordIndex] + "\" на шаге " + runCount);
                        run = false;
                    }
            }
            runCount++;
        }
    }
}
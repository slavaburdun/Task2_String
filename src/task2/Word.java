package task2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {

    ArrayList<Character> word;

    public Word() {
        this.word = new ArrayList<>();
    }

    public ArrayList<Character> getWord() {
        return word;
    }

    public void setWord(ArrayList<Character> word) {
        this.word = word;
    }

    public void addCharacterToPosition(int position, Character sym) {
        word.add(position, sym);
    }

    public void addCharacter(Character character) {
        word.add(character);
    }

    public static ArrayList<Word> getAllWordsFromString(String string) {
        ArrayList<Word> words = new ArrayList<>();
        Matcher matcherWords = Pattern.compile("[a-zA-Zа-яА-Я-]+").matcher(string);
        while (matcherWords.find()) {
            words.add(retrieveWordFromChars(matcherWords.group().toCharArray()));
        }
        return words;
    }

    public static Word retrieveWordFromChars(char[] chars) {
        Word w = new Word();
        for (int i = 0; i < chars.length; i++) {
            w.addCharacter(new Character(chars[i]));
        }
        return w;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;
        if (!Objects.equals(this.word, other.word)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.word);
        return hash;
    }

    public void removeCharacter(Character toRemove) {
        word.remove(toRemove);
    }

    public void replaceAllSybmolsWith(Character oldSym, Character newSym) {
        ArrayList<Character> newWord = new ArrayList<>();
        for (Character s : word) {
            if (s.equals(oldSym)) {
                newWord.add(newSym);
            } else {
                newWord.add(s);
            }
        }
        word = newWord;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Character ch : word) {
            result = result.append(ch);
        }
        return result.toString();
    }
}

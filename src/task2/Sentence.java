package task2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

    private ArrayList<Character> sentence;

    public static ArrayList<Sentence> getAllSentences(String content) {
        ArrayList<Sentence> result = new ArrayList<>();
        Matcher matcherSentences = Pattern.compile("(\\S.+?[.!?])(?=\\s+|$)").matcher(content);
        while (matcherSentences.find()) {
            Sentence sent = new Sentence();
            ArrayList<Character> temp = new ArrayList<>();
            for (Character ch : matcherSentences.group().toCharArray()) {
                temp.add(ch);
            }
            sent.setSentence(temp);
            result.add(sent);
        }
        return result;
    }

    public ArrayList<Character> getSentence() {
        return sentence;
    }

    public void setSentence(ArrayList<Character> sentence) {
        this.sentence = sentence;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sentence other = (Sentence) obj;
        if (!Objects.equals(this.sentence, other.sentence)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.sentence);
        return hash;
    }

    public boolean containsWord(Word word) {
        ArrayList<Word> words = Word.getAllWordsFromString(this.toString());
        for (Word wrd : words) {
            if (wrd.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void replaceLastAndFirst() {
        StringBuilder sbObj = new StringBuilder(this.toString());
        ArrayList<Word> words = Word.getAllWordsFromString(sbObj.toString());
        StringBuilder firstWord = new StringBuilder(words.get(0).toString());
        StringBuilder lastWord = new StringBuilder(words.get(words.size() - 1).toString());
        int from = sbObj.indexOf(words.get(0).toString());
        sbObj.replace(from, from + firstWord.length(), lastWord.toString());
        sbObj = sbObj.reverse();
        StringBuilder lastWordReversed = lastWord.reverse();
        StringBuilder firstWordReversed = firstWord.reverse();
        from = sbObj.indexOf(lastWordReversed.toString(), 0);
        sbObj.replace(from, from + lastWord.length(), firstWordReversed.toString());
        sbObj = sbObj.reverse();
        sentence.clear();
        for(Character ch : sbObj.toString().toCharArray()){
            sentence.add(ch);
        }
    }

    public void addWordAtPosition(int position, Word word) {
        sentence.addAll(position, word.getWord());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Character ch : sentence) {
            result = result.append(ch);
        }
        return result.toString();
    }
}

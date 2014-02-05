package task2;

import java.util.ArrayList;

public class Main {

    public static void main(String... args) {
        Text text = new Text();
        text.setPathToFile("test.txt");
        ArrayList<Sentence> sentencesInText = Sentence.getAllSentences(text.getContent().toString());
        ArrayList<Sentence> result = new ArrayList<>();
        for (Sentence sct : sentencesInText) {
            System.out.println(sct);
        }
        System.out.println("---------------------------------------------");
        for (Sentence sc : sentencesInText) {
            sc.replaceLastAndFirst();
            result.add(sc);
        }
        for (Sentence s : result) {
            System.out.println(s);
        }
    }
}

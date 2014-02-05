package task2;

import java.io.*;
import java.util.Objects;

public class Text {

    private String pathToFile;
    private StringBuilder content;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setContent() {
        content = readFile();
    }

    public StringBuilder getContent() {
        if (content == null) {
            setContent();
        }
        return content;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Text other = (Text) obj;
        if (!Objects.equals(this.pathToFile, other.pathToFile)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.pathToFile);
        return hash;
    }

    public StringBuilder readFile() {
        File file = new File(pathToFile);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(file), "UTF-8"));
            String text = null;
            while ((text = reader.readLine()) != null) {
                contents.append(text);
            }
            return contents;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

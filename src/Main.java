import java.io.*;

public class Main {

    private BufferedReader inputReader;
    private BufferedReader keyReader;
    private BufferedReader alphabetReader;
    private BufferedWriter cryptWriter;
    private BufferedWriter decryptWriter;

    public void initializeStreams() throws IOException {
        inputReader = new BufferedReader(new FileReader("in.txt"));
        keyReader = new BufferedReader(new FileReader("key.txt"));
        alphabetReader = new BufferedReader(new FileReader("alphabet.txt"));
        cryptWriter = new BufferedWriter(new FileWriter("crypt.txt", true));
        decryptWriter = new BufferedWriter(new FileWriter("decrypt.txt", true));
    }

    public void closeStreams() {
        try {
            if (inputReader != null) inputReader.close();
            if (keyReader != null) keyReader.close();
            if (alphabetReader != null) alphabetReader.close();
            if (cryptWriter != null) cryptWriter.close();
            if (decryptWriter != null) decryptWriter.close();
        } catch (IOException e) {
            System.err.println("Ошибка закрытия файлов: " + e.getMessage());
        }
    }

    public void shiftMethod() throws IOException {
        String inputLine;
        while ((inputLine = inputReader.readLine()) != null) {
            System.out.println("Читаю строку из in.txt: " + inputLine);
            // Логика шифрования или другие действия
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.initializeStreams();
        main.shiftMethod();
    }
}
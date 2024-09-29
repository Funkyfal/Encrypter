package Ciphers;


public class Cipher {
    private String alphabet;
    private String inputText;
    private String key;

    public Cipher(String alphabet, String inputText, String key) {
        this.alphabet = alphabet;
        this.key = key;
        this.inputText = inputText;
    }

    public String shiftEncrypt() {
        if (key.length() != 1) {
            throw new IllegalArgumentException("Ключ состоит не из одного символа.");
        }

        int index = alphabet.indexOf(key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int tempIndex = (alphabet.indexOf(inputText.charAt(i)) + index) % alphabet.length();
            result.append(alphabet.charAt(tempIndex));
        }

        return result.toString();
    }

    public String shiftDecrypt() {
        if (key.length() != 1) {
            throw new IllegalArgumentException("Ключ состоит не из одного символа.");
        }

        int index = alphabet.indexOf(key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputText.length(); i++) {
            int tempIndex = (alphabet.indexOf(inputText.charAt(i)) - index + alphabet.length()) % alphabet.length();
            result.append(alphabet.charAt(tempIndex));
        }

        return result.toString();
    }

    public String affineEncrypt() {
        if (key.length() != 2 || GCD(alphabet.indexOf(key.charAt(0)), alphabet.length()) != 1) {
            throw new IllegalArgumentException("Либо неверна длина ключа(должна быть 2), либо первый символ ключа" +
                    "не взаимно прост с длиной алфавита.");
        }

        StringBuilder result = new StringBuilder();
        int k1 = alphabet.indexOf(key.charAt(0));
        int k2 = alphabet.indexOf(key.charAt(1));

        for (int i = 0; i < inputText.length(); i++) {
            int tempIndex = ((alphabet.indexOf(inputText.charAt(i)) * k1) + k2) % alphabet.length();
            result.append(alphabet.charAt(tempIndex));
        }

        return result.toString();
    }

    public String affineDecrypt() {
        if (key.length() != 2 || GCD(alphabet.indexOf(key.charAt(0)), alphabet.length()) != 1) {
            throw new IllegalArgumentException("Либо неверна длина ключа(должна быть 2), либо первый символ ключа" +
                    "не взаимно прост с длиной алфавита.");
        }

        StringBuilder result = new StringBuilder();
        int k1 = alphabet.indexOf(key.charAt(0));
        int k2 = alphabet.indexOf(key.charAt(1));

        int k1Reverse = reverseNumber(k1, alphabet.length());

        for (int i = 0; i < inputText.length(); i++) {
            int tempIndex = (k1Reverse * (alphabet.indexOf(inputText.charAt(i)) - k2 + alphabet.length())) % alphabet.length();
            result.append(alphabet.charAt(tempIndex));
        }
        return result.toString();
    }

    public String substitutionEncrypt() {
        if (key.length() != alphabet.length()) {
            throw new IllegalArgumentException("Текст в файле ключа имеет отличную от алфавита длину.");
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < inputText.length(); i++){
            result.append(key.charAt(alphabet.indexOf(inputText.charAt(i))));
        }
        return result.toString();
    }

    public String substitutionDecrypt() {
        if (key.length() != alphabet.length()) {
            throw new IllegalArgumentException("Текст в файле ключа имеет отличную от алфавита длину.");
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < inputText.length(); i++){
            result.append(alphabet.charAt(key.indexOf(inputText.charAt(i))));
        }
        return result.toString();
    }

    private int reverseNumber(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException();
        //случая с исключением не будет, но без обработки исключения не будет работать функция
    }

    public static int GCD(int a, int b) {
        int temp;
        while (b != 0) {
            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}

import java.util.ArrayList;
import java.util.List;

public class TextEncryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    public String readerFile(String url, int shift, int mode) {
        char[] charText = WorkingWithFile.readerFile(url);
        return encryption(charText, shift, mode);
    }

    public String readerFileBruteForce(String url) {
        char[] charText = WorkingWithFile.readerFile(url);
        return encryptionBruteForce(charText);
    }

    private String encryption(char[] text, int shift, int mode) {
        if (shift > ALPHABET.length) shift = shift % ALPHABET.length;
        char[] arrChar = new char[text.length];
        int count = 0;
        for (int i = 0; i < text.length; i++) {
            arrChar[i] = text[i];
            for (int j = 0; j < ALPHABET.length; j++) {
                if (count + shift == ALPHABET.length) count = 0 - shift;
                if (mode == 1) {
                    if (ALPHABET[j] == Character.toLowerCase(text[i])) {
                        if (ALPHABET[j] == text[i]) arrChar[i] = ALPHABET[count + shift];
                        else arrChar[i] = Character.toUpperCase(ALPHABET[count + shift]);
                        break;
                    }
                } else if (mode == 2) {
                    if (ALPHABET[count + shift] == Character.toLowerCase(text[i])) {
                        if (ALPHABET[count + shift] == text[i]) arrChar[i] = ALPHABET[j];
                        else arrChar[i] = Character.toUpperCase(ALPHABET[j]);
                        break;
                    }
                }
                count++;
            }
            count = 0;
        }
        System.out.println();
        String result = new String(arrChar);
        System.out.println(result);
        return result;
    }

    private String encryptionBruteForce(char[] text) {
        int shift = 1;
        String result = "";
        while (shift < ALPHABET.length) {
            int count = 0;
            char[] arrChar = new char[text.length];
            for (int i = 0; i < text.length; i++) {
                arrChar[i] = text[i];
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (count + shift == ALPHABET.length) count = 0 - shift;
                    if (ALPHABET[j] == Character.toLowerCase(text[i])) {
                        if (ALPHABET[j] == text[i]) arrChar[i] = ALPHABET[count + shift];
                        else arrChar[i] = Character.toUpperCase(ALPHABET[count + shift]);
                        break;
                    }
                    count++;
                }
                count = 0;
            }
            result += "Номер ключа - " + (ALPHABET.length - shift) + "\n";
            result += new String(arrChar);
            result += "\n" + "-".repeat(20) + "\n";
            shift++;
        }
        return result;
    }
}
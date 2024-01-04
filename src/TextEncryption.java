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
            for (char c : ALPHABET) {
                if (count + shift == ALPHABET.length) count = -shift;
                if (mode == 1) {
                    if (c == Character.toLowerCase(text[i])) {
                        if (c == text[i]) arrChar[i] = ALPHABET[count + shift];
                        else arrChar[i] = Character.toUpperCase(ALPHABET[count + shift]);
                        break;
                    }
                } else if (mode == 2) {
                    if (ALPHABET[count + shift] == Character.toLowerCase(text[i])) {
                        if (ALPHABET[count + shift] == text[i]) arrChar[i] = c;
                        else arrChar[i] = Character.toUpperCase(c);
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
        StringBuilder result = new StringBuilder();
        while (shift < ALPHABET.length) {
            int count = 0;
            char[] arrChar = new char[text.length];
            for (int i = 0; i < text.length; i++) {
                arrChar[i] = text[i];
                for (char c : ALPHABET) {
                    if (count + shift == ALPHABET.length) count = -shift;
                    if (c == Character.toLowerCase(text[i])) {
                        if (c == text[i]) arrChar[i] = ALPHABET[count + shift];
                        else arrChar[i] = Character.toUpperCase(ALPHABET[count + shift]);
                        break;
                    }
                    count++;
                }
                count = 0;
            }
            result.append("Номер ключа - ").append(ALPHABET.length - shift).append("\n");
            result.append(new String(arrChar));
            result.append("\n").append("-".repeat(20)).append("\n");
            shift++;
        }
        return result.toString();
    }
}
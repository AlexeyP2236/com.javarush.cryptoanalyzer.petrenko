import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите число:\n" +
                    "1 - Сделать шифровку;\n" +
                    "2 - Расшифровать файл;\n" +
                    "3 - Взломать файл;\n" +
                    "4 - exit");
            String console = in.nextLine();
            if (console.equals("1")) {
                int mode = 1;
                Interface.interfaceEncryption(mode);
            } else if (console.equals("2")) {
                int mode = 2;
                Interface.interfaceEncryption(mode);
            } else if (console.equals("3")) {

            } else if (console.equals("4") || console.equals("exit")) break;
            else System.out.println("Неверный ввод");
        }
    }
}
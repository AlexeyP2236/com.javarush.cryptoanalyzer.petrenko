import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        label:
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("""
                    Введите число:
                    1 - Сделать шифровку;
                    2 - Расшифровать файл;
                    3 - Взломать файл;
                    4 - Выход""");
            String console = in.nextLine();
            int mode;
            switch (console) {
                case "1":
                    mode = 1;
                    Interface.interfaceEncryption(mode);
                    break;
                case "2":
                    mode = 2;
                    Interface.interfaceEncryption(mode);
                    break;
                case "3":
                    mode = 3;
                    Interface.interfaceEncryption(mode);
                    break;
                case "4":
                case "exit":
                    break label;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }
}